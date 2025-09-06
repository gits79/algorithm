import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken()); 
            int N = Integer.parseInt(st.nextToken()); 

            int[] cap = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                cap[i] = R * C; 
            }

            Arrays.sort(cap);

            int need = J, cnt = 0;
            for (int i = N - 1; i >= 0 && need > 0; i--) {
                need -= cap[i];
                cnt++;
            }

            System.out.println(cnt);
        }
    }
}
