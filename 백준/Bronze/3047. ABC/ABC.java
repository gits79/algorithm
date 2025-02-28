import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        String s = br.readLine();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            if (s.charAt(j) == 'A') {
                sb.append(arr[0]).append(" ");
            } else if (s.charAt(j) == 'B') {
                sb.append(arr[1]).append(" ");
            } else if (s.charAt(j) == 'C') {
                sb.append(arr[2]).append(" ");
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}