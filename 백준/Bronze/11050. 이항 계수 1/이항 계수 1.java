import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		arr[0] = 1;
		int result = fac(N) / fac(K) / fac(N-K);
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] arr;

	static int fac (int n) {
		if( n < 2) {
			return 1;
		}
		
		if(arr[n] == 0) {
			arr[n] = n * fac(n-1);
		}
		return arr[n];
	}
}
