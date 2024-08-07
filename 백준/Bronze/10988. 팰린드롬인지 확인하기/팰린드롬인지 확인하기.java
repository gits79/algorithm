import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		String pal = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			pal += str.charAt(i);
		}

		if(str.equals(pal))
			System.out.println(1);
		else
			System.out.println(0);
		
		
	}
}
