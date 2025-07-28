import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, arr[];
    static List<int[]> lst = new ArrayList<int[]>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lst.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(lst, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int len = 0;

        for (int i = 0; i < N; i++) {
            int[] temp = lst.get(i);
            int start = temp[0];
            int end = temp[1];
            if (start >= len) {
                len = end;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
