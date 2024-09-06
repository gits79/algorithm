import java.util.*;
import java.io.*;

public class Main {

	static int N, M, parents[];

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N];
		make();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int conn = Integer.parseInt(st.nextToken());
				if (conn == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		boolean answer = true;
		int root = findSet(arr[0]);
		for (int i = 1; i < M; i++) {
			if (root != findSet(arr[i])) {
				answer = false;
				break;
			}
		}

		if (answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
