import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int count0;
    static int count1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        divide(N, 0, 0);

        System.out.println(count0);
        System.out.println(count1);

    }

    static void divide(int N, int x, int y) {
        int num = arr[x][y];
        if (N == 1) {
            if (num == 0) {
                count0++;
            } else {
                count1++;
            }
            return;
        }

        for (int i = y; i < y+N; i++) {
            for (int j = x; j < x + N; j++) {
                if (arr[j][i] != num) {
                    divide(N/2,x,y);
                    divide(N/2,x+N/2,y);
                    divide(N/2,x,y+N/2);
                    divide(N/2,x+N/2,y+N/2);
                    return;
                }
            }
        }

        if (num == 0) {
            count0++;
        } else {
            count1++;
        }
        return;


    }


}
