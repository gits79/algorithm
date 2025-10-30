import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
//         Map<String, Integer> map1 = new HashMap<>();
//         Map<String, Integer> map2 = new HashMap<>();
//         int size = participant.length;
//         String answer = "";
        
//         for(int i = 0; i < size; i++) {
//             map1.put(participant[i], map1.getOrDefault(participant[i] , 0) + 1);
//             if(i < completion.length) 
//             map2.put(completion[i], map2.getOrDefault(completion[i] , 0) + 1);
//         }

//         for(String s : map1.keySet()){
//             if(map1.get(s) != map2.getOrDefault(s , 0)) {
//                 answer += s;
//                 break;
//             }
//         }
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                answer += participant[i];
                break;
            }
        }
        
    
        
        
        return answer.length() != 0 ? answer : participant[participant.length - 1];

    }
}