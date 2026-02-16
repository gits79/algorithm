import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String op = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String nums = br.readLine();

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            
            if (n > 0) {
                nums = nums.substring(1, nums.length() - 1); 
                String[] parts = nums.split(",");
                for (String p : parts) dq.addLast(Integer.parseInt(p));
            }

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < op.length(); i++) {
                char c = op.charAt(i);
                if (c == 'R') {
                    reversed = !reversed;
                } else { 
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reversed) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (error) {
                out.append("error\n");
                continue;
            }

            out.append("[");
            if (!dq.isEmpty()) {
                if (!reversed) {
                    while (!dq.isEmpty()) {
                        out.append(dq.pollFirst());
                        if (!dq.isEmpty()) out.append(",");
                    }
                } else {
                    while (!dq.isEmpty()) {
                        out.append(dq.pollLast());
                        if (!dq.isEmpty()) out.append(",");
                    }
                }
            }
            out.append("]\n");
        }

        System.out.print(out);
    }
}
