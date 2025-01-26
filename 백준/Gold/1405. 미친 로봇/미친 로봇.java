import java.io.*;
import java.util.*;


public class Main {

    static int N, size = 30;
    static double answer = 0;
    static int[] arr;
    static boolean[][] v = new boolean[size][size];
    static final int[] di = {0, 0, 1, -1};
    static final int[] dj = {1, -1, 0, 0};

    static void recur(int cur, int i, int j, double sum) {
        if (cur == N) {
            answer += sum;
            return;
        }

        v[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (checkIdx(ni, nj) && !v[ni][nj]) {
                v[ni][nj] = true;
                recur(cur + 1, ni, nj, sum * arr[d] * 0.01);
                v[ni][nj] = false;
            }

        }

    }

    static boolean checkIdx(int i, int j) {
        if (0 <= i && i < size && 0 <= j && j < size) return true;
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 15, 15, 1);
        System.out.println(answer);

    }
}
