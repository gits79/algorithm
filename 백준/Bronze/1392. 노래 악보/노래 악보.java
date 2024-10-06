import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(bufferedReader.readLine());

            while (t-- > 0) {
                list.add(i);
            }
        }

        while (q-- > 0) {
            sb.append(list.get(Integer.parseInt(bufferedReader.readLine()))).append("\n");
        }

        System.out.println(sb);
    }
}