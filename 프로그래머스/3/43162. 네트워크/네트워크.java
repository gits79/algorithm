import java.util.*;

class Solution {
    static int N, parent[];
    
    static void init(){
        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;
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
    
    static boolean connected(int n1, int n2) {
        return find(n1) == find(n2);
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        init();
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[0].length; j++) {
                if(computers[i][j] == 1) {
                    union(i , j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(find(i));
        }
        
        return set.size();
    }
}