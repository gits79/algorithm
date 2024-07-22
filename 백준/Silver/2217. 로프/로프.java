import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr, Collections.reverseOrder());
		int max = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i ++) {
			sum += arr[i];
			int temp = sum / (i + 1);
			if (arr[i] * (i + 1) > temp)
				max = Math.max(max, arr[i] * (i + 1));
			else
				max = Math.max(max, temp);
		}
		
		System.out.println(max);

	}
}
