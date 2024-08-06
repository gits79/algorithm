import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Deque<Character> deque = new ArrayDeque<Character>();
		
		for(int tc = 0; tc < T;tc++ ) {
			deque.clear();
			char[] arr = br.readLine().toCharArray();
			for(int i = 0 ; i< arr.length; i++) {
				if(deque.isEmpty()) {

					deque.add(arr[i]);
					continue;
				}
				
				
				if(arr[i] == '(') {
					deque.add(arr[i]);
					continue;
				}
				
				char c = deque.peekLast();
				if(c =='(') {
					deque.pollLast();
				}else {
					deque.add(arr[i]);
				}
				
			}
			sb.append(deque.isEmpty()? "YES" : "NO").append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
