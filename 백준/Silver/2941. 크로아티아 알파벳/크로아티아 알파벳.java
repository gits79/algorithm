import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		int cnt = 0;
		String temp = "";
		for (String s : arr) {
			while (true) {
				if (str.contains(s)) {
					cnt++;
					str = str.replaceFirst(s, " ");
					temp += s;

				} else {
					break;
				}
			}

		}
		str = str.replaceAll(" ", "");
		System.out.println(str.length() + cnt);

	}

}
