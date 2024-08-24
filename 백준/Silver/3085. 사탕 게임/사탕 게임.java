import java.util.*;
import java.io.*;

public class Main {
	static int n;
    static char[][] arr;
    static int result = 0;

    static final int[] di = { -1, 0, 1, 0 };
    static final int[] dj = { 0, 1, 0, -1 };

    
    static int cal() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    answer = Math.max(answer, cnt);
                    cnt = 1;
                }
            }
            answer = Math.max(answer, cnt);
        }

        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    answer = Math.max(answer, cnt);
                    cnt = 1;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }


    static void dfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    
                    if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                        char temp = arr[i][j];
                        arr[i][j] = arr[ni][nj];
                        arr[ni][nj] = temp;

                        result = Math.max(result, cal());

                        temp = arr[i][j];
                        arr[i][j] = arr[ni][nj];
                        arr[ni][nj] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++)
                arr[i][j] = str.charAt(j);
        }

        dfs();

        System.out.println(result);
    }
}