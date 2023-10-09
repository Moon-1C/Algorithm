import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        sb = new StringBuffer();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(str.charAt(j)+"");
            }
        }

        divide(N,0,0);
        System.out.println(sb);



    }


    static void divide(int N , int row, int col) {

//        if (N ==0) {
//            return;
//        }

        int now = arr[row][col];
        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (now != arr[i][j]) {

                    sb.append("(");
                    divide(N/2,row,col);
                    divide(N/2,row,col+N/2);
                    divide(N/2,row+N/2,col);
                    divide(N/2,row+N/2,col+N/2);
                    sb.append(")");
                    return;

                }


            }
        }

        sb.append(now);

    }


}
