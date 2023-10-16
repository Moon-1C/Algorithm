import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.clear();
            Long sum = 0L;
            int K = Integer.valueOf(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.offer(Long.valueOf(st.nextToken()));
            }

            while (pq.size() > 1) {
                Long num1 = pq.poll();
                Long num2 = pq.poll();
                Long plus = num1 + num2;
                sum += plus;
                pq.offer(plus);
            }
            System.out.println(sum);

        }




    }

}