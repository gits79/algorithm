import java.util.*;

class Node {
    int vertex;
    Node next;
    
    Node(int vertex, Node next) {
        this.vertex = vertex;
        this.next = next;
    }
}

class Solution {
    
    static boolean[] v;
    static List<Integer>[] lst;
    
    public int search() {
        int cnt = 1;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        v[1] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            cnt = size;
            // System.out.println("cnt: " + cnt + " , size: " + size);
            while(--size >= 0) {
                int cur = q.poll();
                // System.out.println("cnt: " + cnt + " , cur: " + cur);
                for(int next : lst[cur]) {
                    if(!v[next]) {
                        q.offer(next);
                        v[next] = true;
                    }
                }
                
            }
            // cnt++;
        }
        return cnt;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        v = new boolean[n + 1];
        lst = new List[n + 1];
        for(int i = 0; i <= n; i++) lst[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            lst[a].add(b);
            lst[b].add(a);
        }
        // for(int i = 0; i < lst.size(); i++){
        //     for(int n: lst.get(i))
        //     System.out.println(n);
        // }    
        answer = search();
        return answer;
    }
}