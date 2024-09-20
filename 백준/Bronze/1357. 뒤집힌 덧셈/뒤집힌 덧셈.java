import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");

        int sum = 0;
        for (int i = 0; i< token.length; i++ ){
            String str = "";

           char[] arr = token[i].toCharArray();

           for (int j = arr.length-1; j >= 0; j--){
               str += arr[j];
           }

           sum += Integer.parseInt(str);
        }

        String rev = String.valueOf(sum);

        int flag = 0; 


        for (int i = rev.length()-1; i >=0 ; i--){
            if (rev.charAt(i) != '0'){ 
                flag = 1;
            }

            if (flag == 1) System.out.print(rev.charAt(i));
        }
    }
}