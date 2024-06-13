

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();		
		String[] arr = new String[n];
		ArrayList<Character> answer = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			arr[i] = str;
		}
		
		for(int i = 0; i < n; i++) {
			int count = 0;
			char temp = arr[i].charAt(0);

			for(int j = 0; j < n; j++) {
				if (temp == arr[j].charAt(0))
					count += 1;
			}
			if (count >= 5)
				if (answer.contains(temp) == false)
					answer.add(temp);
		}
		Collections.sort(answer);
		String result = "";
		if (answer.size() > 0) {
			
			for(char a : answer)
				result += a;
			System.out.println(result);
		}
		
		else
			System.out.println("PREDAJA");
		
		
	}
}
