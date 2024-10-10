import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
		int val = 0;
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());

			if(M == 0) {
				val = 0;
			}else {
				val += 1;
			}
			sum += val;
		}
		System.out.println(sum);
	}

}