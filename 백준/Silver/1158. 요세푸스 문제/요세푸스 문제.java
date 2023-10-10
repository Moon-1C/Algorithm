import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());


        Queue<Integer> queue = new LinkedList<>();

        sb.append("<");
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < K-1; i++) {
                queue.add(queue.poll());
            }
            int now = queue.poll();
            sb.append(now).append(", ");


        }

        sb.append(queue.poll()).append(">");

        System.out.println(sb);




    }


}
