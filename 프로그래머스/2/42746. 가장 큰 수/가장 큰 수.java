import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> lst = new ArrayList<>();
        for(int n : numbers) {
            String s = n + "";
            lst.add(s);
        }
        // Collections.sort(lst, (o1, o2)-> {
        //     int size = Math.min(o1.length(), o2.length());
        //     for(int i = 0; i < size; i++) {
        //         if(o1.charAt(i) - '0' > o2.charAt(i) - '0') return o2 - o1;
        //     }
        //     return o2 - o1;
        // });
        Collections.sort(lst, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String s : lst) answer += s;
        return (answer.charAt(0) == '0' ? "0" : answer);
    }
}