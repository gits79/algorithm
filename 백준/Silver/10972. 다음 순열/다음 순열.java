import java.util.*;
import java.io.*;

public class Main {

	static int N, C = 0;
	static int[] a;
	static ArrayList<int[]> lst = new ArrayList<>();

	static void swap(int i, int j) {
		int T = a[i];
		a[i] = a[j];
		a[j] = T;
	}

	static boolean nPn() {
		int i = N - 1; // i는 교환위치 찾기
		while (i > 0 && a[i - 1] >= a[i])
			i--;
		if (i == 0)
			return false;

		int j = N - 1; // j는 교환할값 찾기
		while (/* j > 0 && */a[i - 1] >= a[j])
			j--;
		swap(i - 1, j);

		int k = N - 1; // k는 오름차순 정렬
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());

		C = 0;

		do {
			C++;
			lst.add(Arrays.copyOf(a, N));
			if (C == 2)
				break;
		} while (nPn());

		if (C == 2) {
			int[] temp = lst.get(1);
			for (int i = 0; i < N; i++)
				System.out.print(temp[i] + " ");
		}

		else
			System.out.println(-1);
	}

}