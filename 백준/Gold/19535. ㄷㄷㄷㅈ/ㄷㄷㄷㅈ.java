import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static long Dcount;
    static long Gcount;

    static boolean visited[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            int node1 = Integer.valueOf(st.nextToken());
            int node2 =  Integer.valueOf(st.nextToken());

            list[node1].add(node2);
            list[node2].add(node1);

        }
        Dcount = 0;
        Gcount = 0;

        BFS(1);


        if (Dcount == 3 * Gcount) {
            System.out.println("DUDUDUNGA");
        } else if (Dcount > 3 * Gcount) {
            System.out.println("D");
        } else {
            System.out.println("G");
        }


    }


    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (list[now].size() >= 3) {
                long size = list[now].size();
                Gcount += (size) * (size - 1) * (size - 2) / 6;
            }

            for (int a: list[now]) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);

                    if (list[a].size() >= 2 && list[now].size() >= 2) {
                        Dcount += (list[a].size() - 1) * (list[now].size() - 1);
                    }


                }

            }
        }

}}
