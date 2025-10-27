import java.util.*;

class Node {
    String city;
    int cnt;
    Node(String city, int cnt) {
        this.city = city;
        this.cnt = cnt;
    }
    public String toString(){
        return ("city: " + city + " , " + "cnt: " + cnt);
    }
}

class Solution {
    
    public int search(List<Node> lst, String city) {
        for(int i = 0; i < lst.size(); i++) {
            if(lst.get(i).city.equals(city)) {
                lst.get(i).cnt = -1;
                return i;
            }
        }
        return -1;
    }
    
    public void pageCount(List<Node> lst) {
        for(Node n : lst) n.cnt++;
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<Node> lst = new ArrayList<>();
        if (cacheSize == 0) return 5 * cities.length;
        int N = cacheSize;
        int M = cities.length;
        int hit = 0;
        int miss = 0;
        
        for(int i = 0; i < M; i++) {
            
            lst.sort((o1, o2) -> {
           return o2.cnt - o1.cnt; 
        });
            
            int idx = search(lst, cities[i].toUpperCase());
            if(idx != -1) {
                hit++;
            }
            else{
                if(lst.size() < N) {
                    lst.add(new Node(cities[i].toUpperCase(), 0));
                }
                else{
                    if(!lst.isEmpty()) lst.remove(0);
                    lst.add(new Node(cities[i].toUpperCase(), 0));
                }
                miss++;
            }
            pageCount(lst);
            
        }
        
        answer += hit * 1 + miss * 5;
        
        return answer;
    }
}