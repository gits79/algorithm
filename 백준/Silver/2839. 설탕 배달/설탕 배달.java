
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                cnt++;
                N -= 5;
            } else if (N >= 3) {
                cnt++;
                N -= 3;
            } else break;

        }

        if (N == 0) System.out.println(cnt);
        else System.out.println(-1);

    }
}
