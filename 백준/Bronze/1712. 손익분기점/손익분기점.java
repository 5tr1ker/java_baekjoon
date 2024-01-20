import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long ans = 1;
        if(b >= c) {
            System.out.println(-1);

            return;
        }

        for( ; ; ans++) {
            if(a + b * ans < c * ans) {
                break;
            }
        }

        System.out.println(ans);
    }
}