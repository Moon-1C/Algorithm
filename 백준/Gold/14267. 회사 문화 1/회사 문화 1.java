import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int arr[];


    public static void main(String[] args) throws IOException {
        // 제일 낮은 후보까지 찾는 유니온 파인드를 해야함

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        arr = new int[N + 1];

        for (int i = 1; i < N+1; i++) {
            //i 후배  K 상사   상사에 후배들을 넣음 나중에 자기 후배들한테 자기 점수를 주기 위해
            
            int K = sc.nextInt();
            if (K == -1) {
                continue;
            }
            list[K].add(i);
        }

        for (int i = 0; i < M; i++) {
            int worker = sc.nextInt();
            int weight = sc.nextInt();

            arr[worker] += weight;
        }
        DFS(1);

        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append(" ");

        }
        System.out.println(sb);
        


    }

    static void DFS(int index) {
        for (int next:list[index]){
            arr[next] += arr[index];
            DFS(next);

        }


    }


}
