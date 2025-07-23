import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            stack.clear();
            String answer = "yes";

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[')
                    stack.push(c);
                else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        answer = "no";
                        break;
                    } else {
                        char last = stack.pop();
                        if (c == ')') {
                            if (last != '(')
                                answer = "no";
                        } else if (c == ']') {
                            if (last != '[')
                                answer = "no";
                        }
                    }
                }

            }
            System.out.println((stack.isEmpty()) ? answer : "no");

        }


    }
}
