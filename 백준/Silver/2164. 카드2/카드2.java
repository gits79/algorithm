import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> s = new ArrayDeque<>();
		for (int i = 1; i <= n; i++)
			s.push(i);

		while (s.size() != 1) {
			s.pollLast();
			if (s.size() == 1)
				break;

			s.push(s.pollLast());

		}
		System.out.println(s.peek());

	}
}
