import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Homework> lst = new ArrayList<Homework>();
    static int[] check;

    static class Homework {
        int d;
        int w;

        public Homework(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        check = new int[1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lst.add(new Homework(d, w));
        }

        lst.sort((o1, o2) -> o2.w - o1.w);

        for (Homework h : lst) {
            for (int i = h.d; i > 0; i--) {
                if (check[i] == 0) {
                    check[i] = h.w;
                    break;
                }
            }
        }

        int total = 0;
        for (int n : check) {
            total += n;
        }
        System.out.println(total);

    }
}
