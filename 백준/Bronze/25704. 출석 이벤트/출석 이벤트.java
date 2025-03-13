
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int P=Integer.parseInt(br.readLine());

        int result=0;

        List<Integer> num=new ArrayList<Integer>();

        num.add(0);

        if(N>=5){
            num.add(500);
        }

        if(N>=10){
            num.add(P/10);
        }

        if(N>=15){
            num.add(2000);

        }if(N>=20){
            num.add(P/4);
        }

        result=P-Collections.max(num);

        if(result<0){
            result=0;
        }

        System.out.println(result);
    }
}