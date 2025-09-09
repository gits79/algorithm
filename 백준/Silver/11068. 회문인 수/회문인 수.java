import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int res = 0; 
            for (int B = 2; B <= 64; B++) {
                if (res == 1) break; 

                int mok = N;
                ArrayList<Integer> digits = new ArrayList<>();
                if (mok == 0) digits.add(0);
                while (mok > 0) {
                    digits.add(mok % B);
                    mok /= B;
                }

                boolean ok = true;
                for (int i = 0, j = digits.size() - 1; i < j; i++, j--) {
                    if (!digits.get(i).equals(digits.get(j))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) res = 1;
            }

            System.out.println(res);
        }
    }
}
