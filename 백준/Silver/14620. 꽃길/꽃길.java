import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;

/**
 * 꽃길
 */
public class Main {

    static int[][] arr;

    static boolean[][] visited;
    static int[] dy = {0,0,1,-1,0};
    static int[] dx = {1,-1,0,0,0};

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        arr= new int[N][N];
        int divide = N-2;

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new  StringTokenizer(br.readLine());
            for (int j = 0; j <N; j++) {

            
                int now = Integer.parseInt(st.nextToken());
                


                arr[i][j] = now;
            }


        }



        for (int i = 0; i < (N-2)*(N-2); i++) {
            for (int j = i+1; j < (N-2)*(N-2); j++) {
                for (int k = j+1; k < (N-2)*(N-2); k++) {
                    
                    int row1 = i/divide+1;
                    int cal1 = i%divide+1; 

                    int row2 = j/divide+1;
                    int cal2 = j%divide+1; 

                    int row3 = k/divide+1;
                    int cal3 = k%divide+1; 

                    // System.out.println(row1+" "+ cal1);
                    // System.out.println(row2+" "+ cal2);
                    // System.out.println(row3+" "+ cal3);

                    Node node1 = new Node(row1, cal1);
                    Node node2 = new Node(row2, cal2);
                    Node node3 = new Node(row3, cal3);

              
                    if (isNext(node1,node2) || isNext(node2,node3) || isNext(node1, node3)) {
                        continue;
                    }
                    answer = Math.min(cal(node1, node2, node3),answer);


                }
                
                



            }
        }

        System.out.println(answer);

    }


    static public boolean isNext(Node i, Node k){
 

        for (int j = 0; j < 5; j++) {
            int nowRow = i.x + dx[j];
            int nowCol = i.y + dy[j];

            for (int l = 0; l < 5; l++) {
                int kRow = k.x + dx[l];
                int kCol = k.y + dy[l];


                if (kRow == nowRow && kCol == nowCol) {
                    return true;
                }
            }
        }
        

        return false;
    }

    static public int cal(Node i,Node j, Node k){


        int sum =0;

        for (int j1 = 0; j1 < 5; j1++) {
            int iRow = i.x + dx[j1];
            int iCol = i.y + dy[j1];

            int jRow = j.x + dx[j1];
            int jCol = j.y + dy[j1];

            int kRow = k.x + dx[j1];
            int kCol = k.y + dy[j1];

            

            sum+=arr[iRow][iCol];
            sum+=arr[jRow][jCol];
            sum+=arr[kRow][kCol];
        }
 
        // System.out.println(sum+" "+i+" "+j+" "+k);



        return sum;

    }


    static class Node{
        int x;
        int y ;

        Node(int x ,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return this.x +""+this.y;
        }
    }


}
