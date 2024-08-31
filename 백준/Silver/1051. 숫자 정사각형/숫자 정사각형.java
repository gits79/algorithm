import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static int answer = 1;

    static boolean isValid(int x1, int y1, int x2, int y2) {
        if (x2 < 0 || y2 < 0 || x2 >= N || y2 >= M) return false;
        return arr[x1][y1] == arr[x2][y1] && arr[x1][y1] == arr[x1][y2] && arr[x1][y1] == arr[x2][y2];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; i + k < N && j + k < M; k++) {
                    if (isValid(i, j, i + k, j + k)) {
                        answer = Math.max(answer, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
