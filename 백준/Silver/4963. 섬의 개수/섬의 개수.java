import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] di = {-1, 0, 1, 0, -1, 1, -1, 1};
    static final int[] dj = {0, 1, 0, -1, -1, -1, 1, 1};


    static void dfs(int[][] arr, int i, int j) {
        int width = arr[0].length;
        int height = arr.length;
        arr[i][j] = 0;

        for (int k = 0; k < 8; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= 0 && ni < height && nj >= 0 && nj < width && arr[ni][nj] == 1) {
                dfs(arr, ni, nj);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0)
                break;

            int[][] arr = new int[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        count++;
                        dfs(arr, i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }
}
