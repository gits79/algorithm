import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] alp1 = new int[256];
    static int[] alp2 = new int[256];

    static boolean chk() {
        boolean flag = true;
        for (int i = 0; i < 256; i++) {
            if (alp1[i] != alp2[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String str1 = br.readLine();
        String str2 = br.readLine();
        for (int i = 0; i < N; i++) {
            alp1[str1.charAt(i)] += 1;
        }

        int left = 0;
        int right = 0;
        alp2[str2.charAt(0)] += 1;
        int cnt = 0;

        while (left <= right) {
            if (right - left + 1 == N) {
                if (chk()) cnt++;
            }

            if (right - left + 1 < N) {
                right++;
                if (right == M) break;
                alp2[str2.charAt(right)] += 1;
            } else {
                alp2[str2.charAt(left)] -= 1;
                left++;
            }
        }

        System.out.println(cnt);


    }
}
