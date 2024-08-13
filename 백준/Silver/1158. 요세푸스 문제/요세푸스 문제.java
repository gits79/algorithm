import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> answer = new ArrayDeque<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++)
			q.offer(i);

		int cnt = 0;
		while (!q.isEmpty()) {

			if (q.size() >= k) {
				for (int i = 0; i < k; i++)
					q.offer(q.poll());

				answer.add(q.pollLast());
			}

			else {
				q.offer(q.poll());
				cnt++;
				if (cnt % k == 0 && k > 0)
					answer.add(q.pollLast());

			}

		}

		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = 0;
		for (int num : answer) {
			sb.append(num);
			if (idx < answer.size() - 1)
				sb.append(", ");
			idx++;
		}
		sb.append(">");

		System.out.println(sb);

	}
}
