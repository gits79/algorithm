import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] d = new int[N + 1];
        
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= K; j++) {
                d[0] = i;
                d[1] = j;
                for (int k = 2; k < N; k++) {
                    d[k] = d[k - 1] + d[k - 2];
                }
                if (d[N - 1] == K) {
                    System.out.println(d[0]);
                    System.out.println(d[1]);
                    i = K + 1;
                    break;
                }
            }
        }


    }
}
