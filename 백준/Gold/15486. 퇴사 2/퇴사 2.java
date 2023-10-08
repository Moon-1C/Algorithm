import java.util.*;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            int pay = sc.nextInt();

            T[i] = time;
            P[i] = pay;

        }
        int[] ans = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int time = T[i];
            int pay = P[i];

            if (i + time > N+1) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = Math.max(ans[i + 1], ans[i + time] + pay);
            }

        }

        System.out.println(ans[1]);


    }
}