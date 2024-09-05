
import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;
    static boolean[][] visited;
    static int count=0;
    static List<Integer> list = new ArrayList();


    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};



    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr= new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String str =br.readLine();
            for (int j = 0; j < N; j++) {
                    
                arr[i][j]=Character.getNumericValue(str.charAt(j));

            }
            
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                if (arr[i][j]==1) {
                    BFS(i,j);
                }


            }

        }


        System.out.println(count);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        

    }

    static void BFS(int row, int col){
        if (visited[row][col]) {
            return;
        }

        count++;
        Deque<Node> deque = new ArrayDeque();
        deque.add(new Node(row,col));
        int size = 0;
        while (!deque.isEmpty()) {
            Node now =  deque.poll();
            
            for (int i = 0; i < 4; i++) {
                int nowRow = now.x +dx[i];
                int nowCol = now.y +dy[i];
                
                if (nowRow<0 || nowCol <0 || nowCol>=N || nowRow >= N) {
                    continue;
                }
                if(!visited[nowRow][nowCol] && arr[nowRow][nowCol]==1){
                    visited[nowRow][nowCol] = true;
                    deque.add(new Node(nowRow, nowCol));
                    size++;
                }
            }
        }
        if(size == 0 ){size=1;}
        list.add(size);
    }

    static class Node{
        int x;
        int y;

        Node(int x,int y){
            this.x =x;
            this.y = y;
        }

    }


    static void print(){
        for (int i = 0; i < N; i++) {
            
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
               

            }
            System.out.println();
            
        }

    }

}