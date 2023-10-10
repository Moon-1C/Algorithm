import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Lecture[] lecture  = new Lecture[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int s=sc.nextInt();
            int t = sc.nextInt();

            lecture[i] = new Lecture(s, t);

        }

        Arrays.sort(lecture);
        pq.offer(lecture[0].end);

        for (int i = 1; i < N; i++) {

            if (lecture[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(lecture[i].end);

        }

        System.out.println(pq.size());


    }
    static class Lecture implements Comparable<Lecture> {

        int start, end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {

            if (this.start == o.start)        //빨리 끝나는 순으로 , 시작시간이 빠르면 시작시간 기준 정렬
                return end - o.end;

            return this.start - o.start;
        }
    }


}
