import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (!arr.contains(str))
				arr.add(str);
		}

		Collections.sort(arr, (o1, o2) -> {
			int lengthCompare = Integer.compare(o1.length(), o2.length());
			if (lengthCompare != 0)
				return lengthCompare;

			return o1.compareTo(o2);
		});

		for (String s : arr)
			System.out.println(s);

	}

}
