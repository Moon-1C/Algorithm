
import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int[][] arr;
    static int N;
    static int M;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static HashSet<Node> set = new HashSet<>();



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr= new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
             st = new StringTokenizer(br.readLine());
            int radius = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int j = radius;
            while (j <= N) {
                rotate(j,dir,k);
                j += radius;
//                print();
            }
//            System.out.println("--check--");
            checkArr();



        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j]+" ");
                sum += arr[i][j];
            }
//            System.out.println();
        }

        System.out.println(sum);



    }

    static void checkArr() {

        set.clear();

        boolean remove = false;
        double sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M ; j++) {
                int now = arr[i][j];
                sum += now;
                if (now != 0) {
                    count++;
                }

                for (int k = 0; k < dx.length; k++) {
                    int nowX = (i +dx[k]+N)%N;
                    int nowY = (j +dy[k]+M)%M;
                    if (Math.abs(i - nowX) >=2) {

                        continue;
                    }

                    if (now != 0  && now == arr[nowX][nowY]  ) {
                        remove = true;

                        set.add(new Node(i, j));
                        set.add(new Node(nowX, nowY));

                    }


                }

            }
        }
        if (remove) {
            for (Node n : set) {
                arr[n.x][n.y] = 0;

            }
        }


        if (!remove) {
            double avg = sum / count;

           // System.out.println(avg  );
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    int now = arr[i][j];
                    if (now == 0) {
                        continue;

                    }
                    if (now < avg) {
                        arr[i][j] += 1;
                    } else if (now > avg) {
                        arr[i][j] -= 1;
                    }


                }
            }


        }




    }

    static void rotate(int radius , int dir,int k ){
        radius = radius - 1;
        if (dir == 0) {
            //시계방향 뒤로 밀림  1123   3112
            int[] temp = new int[100];
            for (int i = 0; i < k; i++) {
                temp[i] = arr[radius][(M - k) + i];
            }

            for (int i = M-k-1; i >=0; i--) {
                arr[radius][i+k] = arr[radius][i];
            }

            for (int i = 0; i < k; i++) {
                arr[radius][i] = temp[i];
            }




        } else if (dir == 1) {
            //반시계방향
            int[] temp = new int[100];
            for (int i = 0; i < k; i++) {
                temp[i] = arr[radius][ i];
            }

            for (int i = 0; i < M - k; i++) {
                arr[radius][i] = arr[radius][i+k];
            }

            for (int i = 0; i < k; i++) {
                arr[radius][i+(M-k)] = temp[i];
            }



        } else {
            return;
        }


    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println();

    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }






}