import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb =  new StringBuilder();
       String[] split = br.readLine().split(" ");
       int N = Integer.parseInt(split[0]); 
       int M = Integer.parseInt(split[1]); 
       
       Map<String, String> site = new HashMap<>();
       for(int i=0;i<N;i++) {
    	   split = br.readLine().split(" ");
    	   site.put(split[0], split[1]);
       }
       for(int i=0;i<M;i++) {
    	   sb.append(site.get(br.readLine())).append("\n");
       }
       System.out.println(sb);
	}
}