import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 97; i < 123; i++) {
			char alp = (char) i;
			arr.add(str.indexOf(alp));
		}

		for(int v : arr)
			System.out.print(v + " ");

	}

}
