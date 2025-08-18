import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] prefix = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            long rowSum = 0;
            for (int j = 1; j <= n; j++) {
                rowSum += arr[i][j];
                prefix[i][j] = rowSum;
            }
        }

        for (int j = 1; j <= n; j++) {
            long colSum = 0;
            for (int i = 1; i <= n; i++) {
                colSum += prefix[i][j];
                prefix[i][j] = colSum;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            long res = prefix[x2][y2]
                     - prefix[x1 - 1][y2]
                     - prefix[x2][y1 - 1]
                     + prefix[x1 - 1][y1 - 1];

            sb.append(res).append('\n');
        }

        System.out.print(sb.toString());
    }
}
