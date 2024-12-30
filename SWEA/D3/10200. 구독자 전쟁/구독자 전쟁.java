import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
        	int n = Integer.parseInt(st.nextToken()); 
        	int a = Integer.parseInt(st.nextToken()); 
        	int b = Integer.parseInt(st.nextToken()); 
        	
        	int max = Math.min(a, b);	
        	int min = a+b>n?a+b-n:0;	
			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
}