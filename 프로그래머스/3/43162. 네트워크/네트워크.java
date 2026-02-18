import java.util.*;

class Solution {
    static int N, parent[];
    
    static void init() {
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
    }
    
    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        
        if(a > b) parent[b] = a;
        else parent[a] = b;
         
        
    }
    
    static int find(int k) {
        if(parent[k] != k) parent[k] = find(parent[k]);
        return parent[k];
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        init();
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[0].length; j++) {
                if(computers[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            set.add(find(i));
        }
        return set.size();
    }
}