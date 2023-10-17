import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Call> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.valueOf(st.nextToken());
            int d = Integer.valueOf(st.nextToken());
            pq.offer(new Call(d, p));
        }


        /*
        100 2
        50 10
        20 2
        10 1
        8 2
        5 20
        2 1
         */

        boolean[] arr = new boolean[100002];
        int sum = 0;
        while (!pq.isEmpty()) {
            Call now = pq.poll();
            for (int i = now.d; i > 0; i--) {
                if (arr[i]) {
                    continue;
                } else {
                    arr[i] = true;
                    sum += now.p;
                    break;
                }

            }



        }

        System.out.println(sum);







    }

    static class Call implements Comparable<Call> {

        int d;
        int p;

        Call(int d, int p) {
            this.d = d;
            this.p = p;
        }


        @Override
        public int compareTo(Call o) {
            if (this.p == o.p) {
                return this.d - o.d;
            }
            return o.p-this.p;


        }
    }
}