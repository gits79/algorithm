import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            lst.add(str.substring(i, str.length()));
        }
        Collections.sort(lst);
        for (String s : lst) System.out.println(s);

    }
}