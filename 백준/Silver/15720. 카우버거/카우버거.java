import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int num = Math.min(b,Math.min(c, d));
        int sum = 0;

        Integer [] burger = new Integer[b];
        Integer [] side = new Integer[c];
        Integer [] drink = new Integer[d];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            burger[i] = Integer.parseInt(st.nextToken());
            sum+=burger[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            side[i] = Integer.parseInt(st.nextToken());
            sum+=side[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<d;i++){
            drink[i] = Integer.parseInt(st.nextToken());
            sum+=drink[i];
        }

        Arrays.sort(burger,Collections.reverseOrder());
        Arrays.sort(side,Collections.reverseOrder());
        Arrays.sort(drink,Collections.reverseOrder());

        boolean [] bcheck = new boolean[b];
        boolean [] scheck = new boolean[c];
        boolean [] dcheck = new boolean[d];

        int price = 0;
        for(int i=0;i<num;i++){
            price+=(burger[i]+side[i]+drink[i])*0.9;
            bcheck[i] = true;
            scheck[i] = true;
            dcheck[i] = true;
        }

        for(int i=0;i<b;i++){
            if(!bcheck[i]) price += burger[i];
        }
        for(int i=0;i<c;i++){
            if(!scheck[i]) price += side[i];
        }
        for(int i=0;i<d;i++){
            if(!dcheck[i]) price += drink[i];
        }

        System.out.println(sum);
        System.out.println(price);
    }
}