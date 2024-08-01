import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n == 0)
			System.out.println(0);
		
		else {
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			int temp = 0;
			for(int i = 0; i < n; i++) {
				if(temp + arr[i] < m)
					temp += arr[i];
				else if (temp + arr[i] > m) {
					cnt += 1;
					temp = arr[i];
				}
				else {
					cnt += 1;
					temp = 0;
				}
					
			}
			
			if (temp > 0)
				System.out.println(cnt + 1);
			else
				System.out.println(cnt);
			
			
		}
		

	}

}
