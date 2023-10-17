import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        int M = Integer.valueOf(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());
            int weight = Integer.valueOf(st.nextToken());

            pq.add(new Edge(node1, node2, weight));


        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.node1) != find(now.node2)) {
                union(now.node1, now.node2);
                sum += now.weight;
                count++;
            }
            if (count == N - 1) {
                
                sum -= now.weight;
                break;

            }

        }
        System.out.println(sum);








    }

    static class Edge implements Comparable<Edge> {


        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }



        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }







    static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a != b) {
            arr[b] = a;
        }


    }

    static int find(int a ) {
        if (arr[a] == a) {
            return a;
        } else {
            return find(arr[a]);
        }


    }


}