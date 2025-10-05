import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                } else break;
            }
            answer += stack.size();
            stack.push(height);
        }

        System.out.println(answer);

    }
}
