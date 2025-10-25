import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lst.add(br.readLine());
        }

        lst.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if (0 < num1 && num1 < 10) a += num1;
                    if (0 < num2 && num2 < 10) b += num2;
                }
                if (a == b) return o1.compareTo(o2);
                return a - b;
            }
        });

        for (String s : lst) {
            System.out.println(s);
        }
    }
}