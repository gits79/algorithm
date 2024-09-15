import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int newScore = Integer.parseInt(st.nextToken()); 
        int P = Integer.parseInt(st.nextToken()); 

        
        if (N == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> ranking = new ArrayList<>(); 

        for (int i = 0; i < N; i++) {
            ranking.add(Integer.parseInt(st.nextToken()));
        }

        int rank = 1; 

        
        for (int i = 0; i < N; i++) {
            if (ranking.get(i) > newScore) {
                rank++;
            } else {
                break;
            }
        }

        
        if (N == P && ranking.get(N - 1) >= newScore) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
