import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}

		int answer = 0;
		Stack<Character> stack;
		for (String str : arr) {
			stack = new Stack<>();
			stack.add(' ');
			for (int i = 0; i < str.length(); i++) {
				if (!stack.contains(str.charAt(i)) || stack.get(stack.size() - 1).equals(str.charAt(i))) {
					stack.add(str.charAt(i));
				} else
					break;
			}

			if (str.length() == stack.size() - 1)
				answer++;
		}

		System.out.println(answer);
	}

}
