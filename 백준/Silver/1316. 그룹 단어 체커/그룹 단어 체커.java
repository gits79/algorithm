import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() != c && stack.contains(c)) {
                        flag = false;
                        break;
                    } else stack.push(c);

                }
            }
            if (flag) answer++;
        }

        System.out.println(answer);


    }
}
