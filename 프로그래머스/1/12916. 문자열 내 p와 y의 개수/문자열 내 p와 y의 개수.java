class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();
        int a = 0, b = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P') a++;
            else if(s.charAt(i) == 'Y') b++;
        }

        

        return (a == b) ? true : false;
    }
}