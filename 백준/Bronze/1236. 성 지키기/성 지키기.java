import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            if (!arr[i].contains("X"))
                row++;
        }

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j].charAt(i) == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) col++;
        }


        System.out.println(Math.max(row, col));
    }
}
