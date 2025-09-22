import java.util.*;
import java.io.*;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            goodWordCheck(s);
        }
        System.out.print(count);
    }

    static void goodWordCheck(String s) {
        if (s.length() % 2 == 1) return; 
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0)); 
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) count++;
    }
}