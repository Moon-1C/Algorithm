import java.util.*;
import java.io.*;

/**
 * 경사로
 */
public class Main {

    static int [][] arr;

    static int count = 0;
    static int L;
    static int N;
    

    public static void main(String[] args) throws Exception {


        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr=new int[N][N];

        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
            }
        }

        for (int i = 0; i < N; i++) {
            checkRow(i);
            checkCol(i);        
            

        }

        System.out.println(count);

        
    }

    static void checkRow(int i ){
        
        int[] nowRow = arr[i];
        boolean[] added = new boolean[N];
        
        int before = nowRow[0];


        
        for (int j = 0; j < nowRow.length; j++) {
            


            if(before == nowRow[j]){
                continue;
            }

            int delta = (nowRow[j]-before);
            before = nowRow[j];


            if(delta == 1){
                if(j-L< 0){
                    return;
                }

                for (int k = j-L; k < j; k++) {
                    if(nowRow[j-1] != nowRow[k]|| added[k]==true){
                        return;
                    }

                    added[k] = true;
                }
            }


            else if(delta == -1 ){
                if(j+L-1>= nowRow.length){
                
                    return;
                }

                for (int k = j; k < j+L; k++) {
                    if(nowRow[j] != nowRow[k] || added[k]==true){
                        return;
                    }
                    added[k] = true;
                }
                j+=L-1;
                before = nowRow[j];

            }else{

                return;
            }

            


    
        }
        // System.out.println("row   "+ i);
        count++;

    }

    static void checkCol(int i ){
        
        int[] nowCol = new int[N];
        boolean[] added = new boolean[N];
        for (int j = 0; j < nowCol.length; j++) {
            nowCol[j] = arr[j][i];
        }


        int before = nowCol[0];
        
        for (int j = 0; j < nowCol.length; j++) {

            
            if(before == nowCol[j]){
                
                continue;
            }

            int delta = (nowCol[j]-before);
            before = nowCol[j];


            if(delta == 1){
                if(j-L< 0){
                    return;
                }

                for (int k = j-L; k < j; k++) {
                    if(nowCol[j-1] != nowCol[k]|| added[k]==true){
                        return;
                    }

                    added[k] = true;
                }
            }



        
            else if(delta == -1 ){
                if(j+L-1>= nowCol.length){
                
                    return;
                }

                for (int k = j; k < j+L; k++) {
                    if(nowCol[j] != nowCol[k] || added[k]==true){
                        return;
                    }
                    added[k] = true;
                }
                j+=L-1;
                before = nowCol[j];

            }else{

                return;
            }
        }


        // System.out.println("col   "+ i);
        count++;

    }



}