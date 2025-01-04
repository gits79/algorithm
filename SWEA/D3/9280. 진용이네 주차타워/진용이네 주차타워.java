import java.util.*;
import java.io.*;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int testCase = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] R = new int[n+1];
            int[] W = new int[m+1];
             
            for(int i = 1; i<=n; i++) {
                R[i] = Integer.parseInt(br.readLine());
            }
             
            for(int i = 1; i<=m; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }
             
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i<m*2; i++) {
                int info = Integer.parseInt(br.readLine());
                q.add(info);
            }
            int[] park = new int[n+1];
            int[] info = new int[m+1];
            int sum = 0;
            Queue<Integer> wait = new LinkedList<>();
             
            while(!q.isEmpty()) {
                int car = q.poll();
                 
                if(car > 0) {
                    int parkArea = findPark(park);
                    if(parkArea > 0) {
                        park[parkArea] += 1;
                        sum += W[car] * R[parkArea];
                        info[car] = parkArea;
                    } 
                    else {
                        wait.add(car);
                    }
                }
                else {
                    int parkedArea = info[Math.abs(car)];
                    park[parkedArea] -= 1;
                     
                    if(wait.size() >= 1) {
                        int waiter = wait.poll();
                        info[waiter] = parkedArea;
                        park[parkedArea] += 1;
                        sum += W[waiter] * R[parkedArea];
                    }
                }
                 
            }
            bw.write(String.format("#%d %d\n", t, sum));
        } 
        bw.flush();
    }
    public static int findPark(int[] park) {
        for(int i = 1; i<=park.length-1; i++) {
            if(park[i] == 0)
                return i;
        }
        return -1;
    }
}