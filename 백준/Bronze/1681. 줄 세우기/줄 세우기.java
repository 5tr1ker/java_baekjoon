import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();

        int cnt = 0;
        int i = 1;
        for( ; ; i++) {
            String str = Integer.toString(i);

            if(str.contains(L)) {
                continue;
            }

            cnt ++;

            if(cnt >= N) {
                break;
            }
        }

        System.out.println(i);

    }
}