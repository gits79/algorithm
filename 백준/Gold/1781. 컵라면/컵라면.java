import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static class Homework {
        int weight;
        int value;

        public Homework(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    static class HomeworkComparator implements Comparator<Homework> {
        public int compare(Homework o1, Homework o2) {
            if (o2.weight == o1.weight) return o2.value - o1.value;
            else return o1.weight - o2.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Homework> pq = new PriorityQueue<>(new HomeworkComparator());
        PriorityQueue<Integer> selected = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            Homework homework = new Homework(weight, value);
            pq.add(homework);
        }


        while (!pq.isEmpty()) {
            Homework homework = pq.poll();
            if (homework.weight > selected.size()) {
                selected.offer(homework.value);
            } else {
                if (selected.peek() < homework.value) {
                    selected.poll();
                    selected.offer(homework.value);
                }
            }
        }

        long answer = 0;
        for (int n : selected) {
            answer += n;
        }
        System.out.println(answer);


    }
}
