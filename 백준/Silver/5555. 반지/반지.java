import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=0; i<n; i++) {
			String str2 = br.readLine();
			str2+=str2;
			if(str2.contains(str)) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}