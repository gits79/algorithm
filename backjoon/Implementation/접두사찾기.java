import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		// 자식노드
		Map<Character, Node> child = new HashMap<>();
		// 단어의 끝인지 아닌지 체크
		boolean endOfword;
	}

	static class Trie {
		// Trie의 기본 루트 노드 생성
		Node rootNode = new Node();

		// 문자열 저장
		void insert(String str) {
			// 항상 루트부터 시작
			Node node = this.rootNode;

			// 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
			// 없으면 자식노드 새로 생성
			for (int i = 0; i < str.length(); i++) {
				node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			// 저장 할 문자열의 마지막 단어의 노드에 끝임을 명시
			node.endOfword = true;
		}

		boolean search(String str) {
			// 항상 루트부터 시작
			Node node = this.rootNode;

			// 문자열의 각 단어마다 노드가 존재하는지 체크
			for (int i = 0; i < str.length(); i++) {
				// 문자열의 각 단어에 매핑된 노드가 존재하면 가져오고 아니면 null
				node = node.child.getOrDefault(str.charAt(i), null);
				if (node == null) return false;
				// node가 null이면 현재 트라이에 해당 문자열은 없음
			}
			// 문자열의 마지막 단어인 노드가 까지 존재한다고해서 무조건 문자열이 존재하는것이 아님
			// 현재 노드가 단어의 끝인지 아닌지 체크하는 변수로 리턴
//			return node.endOfword;
			// 이 문제는 해당 문자열이 존재하는지만 확인하기 때문에 그냥 true
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;

		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			trie.insert(str);
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (trie.search(str)) cnt++;
		}

		System.out.println(cnt);

	}
}
