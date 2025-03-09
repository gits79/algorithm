import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        // 자식노드
        // 기존 HashMap에서 자식 노드를 삽입 할 때 자동 정렬이 되는 TreeMap으로 변경
        Map<String, Node> child = new TreeMap<>();

    }

    static class Trie {
        // Trie의 기본 루트 노드 생성
        Node rootNode = new Node();

        // 문자열 저장
        void insert(String[] arr) {
            // 항상 루트부터 시작
            Node node = this.rootNode;

            // 문자열이 자식노드 중에 있는지 체크
            // 없으면 자식노드 새로 생성
            for (int i = 0; i < arr.length; i++) {
                node = node.child.computeIfAbsent(arr[i], key -> new Node());
            }

        }

        static void dfs(Node node, int depth) {
            // 자식 노드를 가져옴 이미 정렬 되어 있기 때문에 정렬할 필요 없음
            for (String key : node.child.keySet()) {
                for (int i = 0; i < depth; i++) System.out.print("--");
                System.out.println(key);
                dfs(node.child.get(key), depth + 1);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] arr = new String[K];
            for (int j = 0; j < K; j++) {
                arr[j] = st.nextToken();
            }
            trie.insert(arr);
        }

        Node node = trie.rootNode;
        trie.dfs(node, 0);
        
    }
}
