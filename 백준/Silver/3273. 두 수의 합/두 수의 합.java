import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int count = 0;


        while (start < end) {
            if (arr[start] + arr[end] == x) {
                count++;
                start++;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else {
                start++;
            }


        }

        System.out.println(count);



    }





}
