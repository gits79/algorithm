import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Egg {
        int v;
        int w;
    }

    static int N, answer = 0;
    static List<Egg> eggs = new ArrayList<Egg>();

    static void backtracking(int idx) {
        if (idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (eggs.get(i).v <= 0) cnt++;
            }
            answer = Math.max(cnt, answer);
            return;
        }
        Egg cur = eggs.get(idx);

        if (cur.v <= 0) {
            backtracking(idx + 1);
            return;
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;
            Egg egg = eggs.get(i);
            if (egg.v <= 0) continue;
            flag = true;
            cur.v -= egg.w;
            egg.v -= cur.w;

            backtracking(idx + 1);
            cur.v += egg.w;
            egg.v += cur.w;


        }
        if (!flag) backtracking(idx + 1);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Egg egg = new Egg();
            egg.v = Integer.parseInt(st.nextToken());
            egg.w = Integer.parseInt(st.nextToken());
            eggs.add(egg);
        }

        backtracking(0);
        System.out.println(answer);

    }
}
