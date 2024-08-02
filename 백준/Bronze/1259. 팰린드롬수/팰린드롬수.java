import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Character> arr = new ArrayDeque<>();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String number;
		while(true) {
			number = br.readLine();
			if(number.equals("0")) {
				break;
			}else {
				if(number.length()==1) {
					sb.append("yes");
				}else {
					for(int i = 0 ; i < number.length(); i++) {
						arr.offer(number.charAt(i));
					}
					
					boolean flag = true;
					while(flag) {
						if( arr.pollLast() == arr.poll() ) {
							if(arr.size() <= 1) {
								sb.append("yes");
								arr.clear();
								flag = false;
							}
						}
						else {
							sb.append("no");
							arr.clear();
							flag = false;
						}
					}
				}
				
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
