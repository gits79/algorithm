import java.util.*;

class Node {
    int idx;
    int cnt;
    String name;
    
    public Node(int idx, int cnt, String name){
        this.idx = idx;
        this.cnt = cnt;
        this.name = name;
    }
}

class Order {
    String genre;
    int total;
    Order(String genre, int total){
        this.genre = genre;
        this.total = total;
    }
}

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        // int[] answer = {};
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
        List<Node> lst = new ArrayList<>();
        List<Order> ord = new ArrayList<>();
        int N = plays.length;
        for(int i = 0; i < N; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
            lst.add(new Node(i, play, genre));
        }
        
        for(String s : map.keySet()) {
            String genre = s;
            int total = map.get(s);
            ord.add(new Order(genre, total));
        }
        
        Collections.sort(ord, (o1, o2) -> {
           return o2.total - o1.total; 
        });
        
        Collections.sort(lst, (o1 ,o2) -> {
           if(o1.cnt == o2.cnt){
               return o1.idx - o2.idx;
           } 
            return o2.cnt - o1.cnt;
        });
        
        // for(Node n : lst) {
        //     System.out.println(n.name + " : " + n.cnt + " : " + n.idx);
        // }
        List<Integer> answer = new ArrayList<>();
        // for(String s : map.keySet()) {
        //     int cnt = 0;
        //     for(int i = 0; i < lst.size(); i++) {
        //         Node n = lst.get(i);
        //         if(!s.equals(n.name)) continue;
        //         answer.add(lst.get(i).idx);
        //         cnt++;
        //         if(cnt == 2)
        //         break;
        //     }
        // }
        
        for(Order o : ord) {
            int cnt = 0;
            for(int i = 0; i < lst.size(); i++) {
                Node n = lst.get(i);
                if(!o.genre.equals(n.name)) continue;
                answer.add(lst.get(i).idx);
                cnt++;
                if(cnt == 2)
                break;
            }
        }
        
        return answer;
    }
}