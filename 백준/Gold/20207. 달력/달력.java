
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Work> works = new PriorityQueue<>();
        List<List<Work>> calender = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            works.add(new Work(s, e));
        }

        int answer = 0;
        int end = -1;
        while (!works.isEmpty()) {
            Work now = works.poll();
            if (end + 1 < now.start) {
                // 새로운 리스트 시작
                if (!calender.isEmpty()) {
                    //처음이 아닌경우
                    answer += (end - calender.get(0).get(0).start+1) * calender.size();
                }
                end = now.end;
                calender.clear();

                List<Work> newDate = new ArrayList<>();
                newDate.add(now);
                calender.add(newDate);
                continue;
            }
            boolean addNew = true;
            for (List<Work> work : calender) {
                Work work1 = work.get(work.size() - 1);

                if (work1.end < now.start) {
                    work.add(now);
                    addNew = false;
                    break;
                }
            }

            if (addNew) {
                List<Work> newDate = new ArrayList<>();
                newDate.add(now);
                calender.add(newDate);
            }

            if (now.end > end) {
                end = now.end;
            }

        }

        if (!calender.isEmpty()) {
            answer += (end - calender.get(0).get(0).start+1) * calender.size();
        }



        System.out.println(answer);




    }

    static class Work implements Comparable<Work>{
        int start;
        int end;

        public Work(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Work o) {
            if (this.start == o.start) {
                return o.end - this.end;
            } else  {
                return this.start - o.start;
            }
        }
    }


}