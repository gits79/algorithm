import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		Set<Integer> arr1 = findNumbers(n1);
		Set<Integer> arr2 = findNumbers(n2);
		arr1.retainAll(arr2);
		List<Integer> list1 = new ArrayList<Integer>(arr1);
		Collections.sort(list1);
		int n3 =list1.get(list1.size()-1);
		int n4 = n1 * n2 / n3;
        System.out.println(n3);
        System.out.println(n4);
	}
	
	static Set<Integer> findNumbers(int n) {
		Set<Integer> arr = new HashSet<Integer>();
        if(n /2 <= 1) {
			arr.add(1);
			arr.add(n);
			return arr;
		}
		for(int i = 1 ; i <= n/2 ; i++) {
			if(n % i == 0) {
				arr.add(i);
				arr.add(n/i);
			}
		}
		return arr;
	} 
}
