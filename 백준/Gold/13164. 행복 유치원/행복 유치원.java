import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int arr[] = new int[N];
        int minus[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            minus[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(minus);
        int sum = 0;
        for (int i = 0; i < N-K+1; i++) {
            sum += minus[i];
        }
        System.out.println(sum);











    }


}
