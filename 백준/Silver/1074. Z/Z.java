import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int count=0;



    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();


        int num = (int)Math.pow(2,N);

        divide(num, r, c);
        System.out.println(count);


    }

    static void divide(int N, int row, int col) {
        if (N == 1) {
            return;
        }

        if (N/2 > row && N/2 > col) {                   //1사분면
            divide(N / 2, row, col);
        } else if (N/2 > row && N/2 <= col) {           //2사분면
            count += N * N / 4;
            divide(N/2,row,col-N/2);

        } else if (N/2 <= row && N/2 > col) {           //3사분면
            count += N * N / 4*2;
            divide(N/2,row-N/2,col);

        }else{
            count += N * N / 4*3;
            divide(N/2,row-N/2,col-N/2);

        }


    }


}
