import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		ArrayDeque<Character> s = new ArrayDeque<>();
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(')
				s.push(c);

			else {
				if (str.charAt(i - 1) == '(') {
					s.pop();
					cnt += s.size();
				} else {
					s.pop();
					cnt++;
				}
			}

		}

		System.out.println(cnt);

	}
}
