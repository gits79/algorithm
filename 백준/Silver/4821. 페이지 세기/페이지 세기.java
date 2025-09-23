import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			boolean print[] = new boolean[n + 1];
			int result = 0;

			String str[] = bf.readLine().split(",");
			for (int i = 0; i < str.length; i++) {
				if (!str[i].contains("-")) {
					if (Integer.parseInt(str[i]) > n) {
						continue;
					}
					if (!print[Integer.parseInt(str[i])]) {
						print[Integer.parseInt(str[i])] = true;
						result += 1;
					}
				} else {
					String num[] = str[i].split("-");
					int a = Integer.parseInt(num[0]);
					int b = Integer.parseInt(num[1]);

					if (a > b || a > n) {
						continue;
					}
					for (int j = a; j <= b; j++) {
						if (j > n) {
							break;
						}
						if (!print[j]) {
							print[j] = true;
							result += 1;
						}
					}
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}