/**
 * 테트로미노
 */
import java.util.*;
import java.io.*;


public class Main {

    static int[][] arr;
    static int[] drow = {0,0,1,-1};
    static int[] dcol = {1,-1,0,0};

    static boolean[][] visited;
    static int N,M;
    static int max = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited= new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i,j);
                dfs(i,j,0,0);
                // visited = new boolean[N][M];



            }
            
        }

        System.out.println(max);


    
    }

    static class Node implements Comparable<Node>{

        int row;
        int col;
        int value;

        Node(int i, int j){
            this.row = i;
            this.col = j;
            this.value = arr[i][j];
        }

        @Override
        public int compareTo(Node n){
            if(n.value == this.value){
                if(n.row  == this.row){
                    return n.col - this.col;
                }else
                    return n.row  - this.row;
            }

            return n.value - this.value;
        }


    }

    static void bfs(int i , int j ){
        
        int count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int sum = 0;
        pq.add(new Node(i, j));

        List<Node> list = new ArrayList<>();

        while(count<4){
            count++;
            Node now = pq.poll();
            list.add(now);

            visited[now.row][now.col] = true;

            sum += now.value;
            for (int k = 0; k < 4; k++) {
                int nextI = now.row + drow[k];
                int nextJ = now.col  + dcol[k];

                if(inRange(nextI, nextJ) && !visited[nextI][nextJ] ){
                    pq.add(new Node(nextI, nextJ));
                }
                
            }
        }
        
        for(Node n : list){
            visited[n.row][n.col] =false;
        }


        if(max<sum){
            max = sum;
            
        }




    }

    static void dfs(int i, int j , int count, int sum){
        if(count == 4 ){
            if(max<sum){
                max = sum;
                
            }
            return;
        }

        sum += arr[i][j];
    

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextI = i + drow[k];
            int nextJ = j  + dcol[k];

            if(inRange(nextI, nextJ) && !visited[nextI][nextJ] ){
                dfs(nextI, nextJ, count+1, sum);
                visited[nextI][nextJ] = false;
            }
            
        }

        visited[i][j] = false;


    }




    static boolean inRange(int i, int j){
        return i>= 0 && i< N && j>=0 && j<M;


    }


}