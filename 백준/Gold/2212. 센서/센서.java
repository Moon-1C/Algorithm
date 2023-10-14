import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int K = Integer.valueOf(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        // 1 3 6 6 7 9
        // 2 3 3 1 2 2
        int[] minus = new int[N-1];

        for (int i = 0; i < N-1; i++) {
            minus[i] = arr[i+1] -arr[i];
        }
        Arrays.sort(minus);

        int sum = 0;
        for (int i = 0; i < N-1-(K-1); i++) {
            sum += minus[i];
        }
        System.out.println(sum);







    }





}
