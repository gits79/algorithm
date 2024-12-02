import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Character> oper;
	static ArrayList<String> answer;
	
	static void opt1(String str) {
		int size = str.length();
		int index = 0;
		// 문자열을 공백을 기준으로 나눠서 각 단어의 시작점만 봄
		String[] temp = str.split(" ");
		for(int i = 0; i < temp.length; i++) {
			// 대소문자를 구별하지 않기에 각 단어를 소문자로 모두 바꿔서 봄
			Character first = Character.toLowerCase(temp[i].charAt(0));
			// 단축키에 지정되어 있지 않는 경우
			if(!oper.contains(first)) {
				oper.add(first);
				join(str, index);
				return;
			}
			// 단축키 지정되는 글자를 찾으면 그 인덱스위치에 [] 를 넣기 위해
			// 인덱스를 각 단어의 사이즈만큼 증가 + 1 은 공백도 같이 증가
			index += temp[i].length() + 1;
		}
		opt2(str);
	}
	
	private static void opt2(String str) {
		for(int i = 0; i < str.length(); i++) {
			Character c = Character.toLowerCase(str.charAt(i));
			// 공백을 단축키로 지정하는 경우 제거
			if(!oper.contains(c) && c != ' ') {
				join(str, i);
				oper.add(c);
				return;
			}
		}
		answer.add(str);
	}

	static void join(String str, int n) {
		String s = "";
		for(int i = 0; i < str.length(); i++) {
			if(i == n) s += "[" + str.charAt(i) + "]";
			else s += str.charAt(i);
		}
		answer.add(s);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		answer = new ArrayList<>();
		oper = new ArrayList<>();
		
		for(int z = 0; z < N; z++) {
			String str = br.readLine();
			opt1(str);
		}
		
		for(String s : answer) System.out.println(s);
	}
}
