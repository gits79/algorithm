import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int maxSejun = 0, maxSebi = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int sejun = Integer.parseInt(st.nextToken());
                if (maxSejun < sejun) maxSejun = sejun;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int sebi = Integer.parseInt(st.nextToken());
                if (maxSebi < sebi) maxSebi = sebi;
            }

            if (maxSejun >= maxSebi) {
                System.out.println("S");
            } else {
                System.out.println("B");
            }
        }
    }
}