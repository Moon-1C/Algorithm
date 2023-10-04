import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

        }
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++)
                dp[j] += dp[j - arr[i]];


        }

        System.out.println(dp[K]);







    }


}