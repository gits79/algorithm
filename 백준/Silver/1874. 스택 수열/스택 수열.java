import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int idx = 0;
        int i = 1;
        while (i <= N || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else if (i <= N) {
                stack.push(i);
                sb.append("+\n");
                i++;
            } else {
                System.out.println("NO");
                return;
            }


        }

        System.out.println(sb);

    }
}
