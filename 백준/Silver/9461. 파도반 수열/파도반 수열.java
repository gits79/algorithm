import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        Long[] d = new Long[102];

        d[1] = 1L;
        d[2] = 1L;
        d[3] = 1L;
        d[4] = 2L;
        d[5] = 2L;
        for (int i = 6; i < 102; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(d[num]);
        }

    }
}
