import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>();
		
		for(int i = 0 ; i < N ; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<String>();
		list.addAll(set);
		Collections.sort(list, (o1, o2)->{
			int len = o1.length() - o2.length();
			if(len == 0) {
				return o1.compareTo(o2);
			}
			
			return len;} );
		
		for(String s : list) sb.append(s).append("\n");
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
