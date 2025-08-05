import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static class Homework {
        int score;
        int time;

        public Homework(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Homework> s = new ArrayDeque<Homework>();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if (time == 1) answer += score;
                else s.push(new Homework(score, time - 1));
            } else {
                if (s.isEmpty()) continue;
                Homework h = s.pop();
                if (h.time == 1) {
                    answer += h.score;
                } else {
                    h.time -= 1;
                    s.push(h);
                }
            }
        }

        System.out.println(answer);


    }
}
