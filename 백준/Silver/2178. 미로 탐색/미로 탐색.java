    import java.io.*;
    import java.util.*;

    public class Main {

        static boolean[][] visited;
        static int[][] A;
        static int[][] arr;
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N][M];
            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int j=0;j<M;j++){
                    arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            BFS(N, M);
            System.out.println(arr[N - 1][M - 1]);






        }

        static void BFS(int N, int M) {
            Queue<int[]> queue = new LinkedList<>();
            int[] start = {0, 0};
            visited[0][0] = true;
            queue.add(start);
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];

                    if (x>=0 &&y>=0 &&x<N && y<M){
                        if (arr[x][y]!=0 && !visited[x][y]){
                            visited[x][y] = true;
                            arr[x][y] = arr[now[0]][now[1]] + 1;
                            queue.add(new int[]{x, y});

                        }

                    }

                }





            }



        }




    }


