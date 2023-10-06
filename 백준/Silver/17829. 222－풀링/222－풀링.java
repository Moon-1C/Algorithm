import java.io.*;
import java.util.*;

public class Main {

    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        while (true) {
            arr = CNN(arr);

            if (arr.length == 1) {
                System.out.println(arr[0][0]);
                return;
            }

        }



    }

    static int[][] CNN(int[][] arr) {

        int N = arr.length;

        int[][] newArr = new int[N / 2][N / 2];


        for (int i = 0; i < N; i+=2) {
            for (int j = 0; j < N; j+=2) {
                PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
                queue.add(arr[i][j]);
                queue.add(arr[i][j+1]);
                queue.add(arr[i+1][j]);
                queue.add(arr[i+1][j+1]);

                queue.poll();
                Integer secondNum = queue.poll();
                newArr[i / 2][j / 2] = secondNum;
            }

        }
        return newArr;
        
    }
}
