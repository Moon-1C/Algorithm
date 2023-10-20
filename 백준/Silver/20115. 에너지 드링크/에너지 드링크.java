import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        double[] arr = new double[N];

        double sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }

        sum = (sum / 2) + (Arrays.stream(arr).max().getAsDouble() / 2);

        System.out.println(sum);
    }


}