import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소
 */
public class Main {

    static int[][] arr, arr2;
    

    static int N,M;

    static int[] drow={0,0,1,-1};
    static int[] dcol={1,-1,0,0};

    static int max= 0;

    static List<Node> viruses = new ArrayList<>();
    
    static boolean[][] visited;

    public static void main(String[] args)throws Exception {
        
    
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        arr= new int[N][M];
        arr2= new int[N][M];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j]==2){
                    viruses.add(new Node(i,j));
                }

            }

        }

        createWall(0);

        System.out.println(max);

 


    }

    static boolean inRange(int i , int j){
        return i >=0 && i < N && j>=0 && j < M && arr[i][j] == 0;

    }

    

    static void bfs(){
        
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr2[i][j] = arr[i][j];

            }
        }


        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < viruses.size(); i++) {
            Node now = viruses.get(i);

            queue.add(now);
        }

        while(!queue.isEmpty()){
            Node nd =queue.poll();

            visited[nd.row][nd.col] =true;
            arr2[nd.row][nd.col] = 2;

            for (int j = 0; j < 4; j++) {
                int nextRow = nd.row + drow[j];
                int nextCol = nd.col + dcol[j];

                if(inRange(nextRow, nextCol) && !visited[nextRow][nextCol]){
                    queue.add(new Node(nextRow,nextCol));
                    arr2[nextRow][nextCol] =2; 
                }


            }
        }
        

        
    }

    static void createWall(int wall) {
    	if (wall == 3) {
    		countSafeArea();
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (arr[i][j] == 0) {
    				arr[i][j] = 1;
    				createWall(wall+1);
    				arr[i][j] = 0;
    			}
    		}
    	}

    }

    static void countSafeArea(){

        bfs();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr2[i][j]==0){
                    count++;
                }
            }
            
        }

        if(count>max){
            max = count;
        }

        visited = new boolean[N][M];

    }


    static class Node{
        int row;
        int col;

        Node(int row,int col){
            this.row = row;
            this.col = col;
        }


    }




}