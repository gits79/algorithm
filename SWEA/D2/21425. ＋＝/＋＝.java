import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
 
    static int A , B, N;
    static int cnt;
 
    public static void main(String args[])  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int i = 0 ; i < T; i++) {
            st= new StringTokenizer(br.readLine()," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            cnt=0;
             
            if(A>B) {
                dfs(A,B);   
            }else {
                dfs(B,A);
            }
             
            sb.append(cnt).append("\n");
             
        }
        System.out.println(sb);
    }
     
     
    public static void dfs (int x , int y) {
        int sum = x+y;
        cnt++;
        if(sum>N) {
            return;
        }
        dfs(sum,x);
    }
 
}