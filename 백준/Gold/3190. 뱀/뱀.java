
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] drow = {0,-1,0,1};
    static int[] dcol = {1,0,-1,0};

    static int degreeIndex = 0;
    static Deque<Node> nextRemove = new ArrayDeque<>();
    static Deque<AngleChange> angleChange = new ArrayDeque<>();

    // L이면 왼쪽회전, 인덱스 증가, D이면 오른쪽 회전, 인덱스 감소

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int arr[][] = new int[N + 1][N + 1];

        arr[1][1] = 1;
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[row][col] = -1;

        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char degree = st.nextToken().charAt(0);
            angleChange.add(new AngleChange(time+1, degree));
        }

        int timer = 0;

        Node now = new Node(1, 1);
        AngleChange first;
        while (true) {
            timer++;

            if (!angleChange.isEmpty()) {
                first = angleChange.getFirst();
                if (first.time == timer) {
                    //todo 방향 전환
                    if (first.Degree == 'D') {
                        degreeIndex = (degreeIndex - 1 + 4) % 4;
                    } else {
                        degreeIndex = (degreeIndex + 1 + 4) % 4;
                    }
                    angleChange.removeFirst();
                }
            }

            Node nextNode = new Node(now.row, now.col, degreeIndex);
            nextRemove.add(now);
            now = nextNode;

            if (now.row > N || now.col > N || now.col < 1 || now.row < 1) {
                System.out.println(timer);
                return;

            }


            if (arr[now.row][now.col] == -1) {
                //사과 먹음 몸이 줄지 않음
                arr[now.row][now.col] = 1;

            } else if (arr[now.row][now.col] == 0) {
                Node node = nextRemove.removeFirst();
                arr[node.row][node.col] = 0;
                arr[now.row][now.col] = 1;

            } else if (arr[nextNode.row][nextNode.col] == 1) {
                System.out.println(timer);
                return;
            }



        }



    }

    static class Node{
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Node(int row, int col,int index) {
            this.row = row;
            this.col = col;

            this.row += drow[index];
            this.col += dcol[index];

        }

    }

    static class AngleChange{
        int time;
        char Degree;

        public AngleChange(int time, char degree) {
            this.time = time;
            Degree = degree;
        }
    }



}