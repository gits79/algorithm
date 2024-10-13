import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= test_case; i++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			boolean isSame = false;
			
			if (N % 2 == 0) {
				for (int j = 0; j <  N / 2; j++) {
					if (str.charAt(j) == str.charAt(j +  N / 2)) {
						isSame = true;
					}
					else {
						isSame = false;
						break;
					}
				}
			}
			else {
				isSame = false;
			}
			
			if (isSame) {
				System.out.println("#" + i + " " + "Yes");
			}
			else if(!isSame) {
				System.out.println("#" + i + " " + "No");
			}
		}
	}
}