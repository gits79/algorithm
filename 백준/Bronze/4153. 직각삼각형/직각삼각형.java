import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) break;
            if (a > b && a > c) {
                int temp = a;
                a = c;
                c = temp;
            }
            if (b > c && b > a) {
                int temp = b;
                b = c;
                c = temp;
            }
            if (a*a + b*b == c*c) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.print(sb);
    }
}