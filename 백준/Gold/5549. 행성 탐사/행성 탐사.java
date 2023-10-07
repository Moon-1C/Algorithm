import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int row = Integer.valueOf(st.nextToken());
        int col = Integer.valueOf(st.nextToken());

        int K = Integer.valueOf(br.readLine());
        char arr[][] = new char[row + 1][col + 1];
        int J[][] = new int[row + 1][col + 1];
        int O[][] = new int[row + 1][col + 1];
        int I[][] = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            String s = br.readLine();
            for (int j = 1; j <= col; j++) {
                char now = s.charAt(j - 1);
                arr[i][j] = now;
                switch (now) {
                    case 'J' :
                        J[i][j] = 1;
                        J[i][j] += J[i - 1][j] + J[i][j - 1] - J[i - 1][j - 1];
                        O[i][j] += O[i - 1][j] + O[i][j - 1] - O[i - 1][j - 1];
                        I[i][j] += I[i - 1][j] + I[i][j - 1] - I[i - 1][j - 1];
                        break;

                    case 'O':

                        O[i][j] = 1;
                        J[i][j] += J[i - 1][j] + J[i][j - 1] - J[i - 1][j - 1];
                        O[i][j] += O[i - 1][j] + O[i][j - 1] - O[i - 1][j - 1];
                        I[i][j] += I[i - 1][j] + I[i][j - 1] - I[i - 1][j - 1];
                        break;

                    case 'I':
                        I[i][j] = 1;
                        J[i][j] += J[i - 1][j] + J[i][j - 1] - J[i - 1][j - 1];
                        O[i][j] += O[i - 1][j] + O[i][j - 1] - O[i - 1][j - 1];
                        I[i][j] += I[i - 1][j] + I[i][j - 1] - I[i - 1][j - 1];
                        break;

                }


            }

        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());

            sb.append(J[x2][y2] - J[x1-1][y2] - J[x2][y1-1] + J[x1-1][y1-1]).append(" ");
            sb.append(O[x2][y2] - O[x1-1][y2] - O[x2][y1-1] + O[x1-1][y1-1]).append(" ");
            sb.append(I[x2][y2] - I[x1-1][y2] - I[x2][y1-1] + I[x1-1][y1-1]).append(" \n");



        }
        System.out.println(sb);



    }





}
