/**
 * 미세먼지_안녕
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int N , M;

    
    static List<Node> airController  = new ArrayList<>();

    static int[] drow ={0,0,1,-1};
    static int[] dcol ={1,-1,0,0};



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        arr= new int[N][M];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;

                if(now == -1){
                    airController.add(new Node(i,j));
                }

            }


        }

        while (T-- >0) {
            spread();
            rotateUp();
            rotateDown();


        }


        print();




        




        
    }


    static class Node{
        int row;
        int col;

        Node(int row , int col){
            this.row = row;
            this.col = col;
        }


    }

    static void spread(){

        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                
                if(arr[i][j] == -1){
                    temp[i][j] = -1;
                    continue;
                }

                int spreadAmount = Math.floorDiv(arr[i][j], 5) ;
                int remain = arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int nextRow = i+drow[k];
                    int nextCol = j+dcol[k];

                    if(inRange(i+drow[k], j+dcol[k])){
                        temp[nextRow][nextCol] += spreadAmount;
                        remain -=spreadAmount;
                    }

                }
                temp[i][j] += remain;
                
            }
            
        }

        arr = temp;

    }

    static boolean inRange(int i, int j){
        return i>=0 && i<N && j>=0 && j<M && arr[i][j] != -1;
    }


    static void print(){

        int sum=2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum+=arr[i][j];
                // System.out.print(arr[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(sum);

    }



    static void rotateUp(){
        Node ac = airController.get(0);
        int[] temp = {arr[0][0], arr[ac.row][0], arr[0][M-1],arr[ac.row][M-1]};

        /*
         * |
         * |
         * |
         * \/
         */

        for (int i = ac.row; i > 0; i--) {
            arr[i][0] = arr[i-1][0];
        }

        /*<-------------
         * 
         * 
         * 
         */

        for (int i = 0; i < M-1; i++) {
            arr[0][i] = arr[0][i+1];
        }

        /*                /\
                           |            
                    *      |
         */


        for (int i = 0; i < ac.row; i++) {
            arr[i][M-1] = arr[i+1][M-1];
        }

        /*
         * 
         * 
         * ----------->
         */

        for (int i = M-1; i > 0; i--) {
            arr[ac.row][i] = arr[ac.row][i-1];
        }

        arr[ac.row][ac.col] = -1;
        arr[ac.row][1] = 0;



    }


    static void rotateDown(){

        Node ac = airController.get(1);

        /*                /\
                           |            
                    *      |
         */


         for (int i = ac.row; i < N-1; i++) {
            arr[i][0] = arr[i+1][0];
        }

        /*<-------------
         * 
         * 
         * 
         */

         for (int i = 0; i < M-1; i++) {
            arr[N-1][i] = arr[N-1][i+1];
        }


                /*
         * |
         * |
         * |
         * \/
         */

         for (int i = N-1; i >= ac.row; i--) {
            arr[i][M-1] = arr[i-1][M-1];
        }


        /*
         * 
         * 
         * ----------->
         */

         for (int i = M-1; i > 0; i--) {
            arr[ac.row][i] = arr[ac.row][i-1];
        }

        arr[ac.row][ac.col] = -1;
        arr[ac.row][1] = 0;



        
    }

}