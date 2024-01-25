import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if(input == null) {
                return;
            }
            StringTokenizer st = new StringTokenizer(input, " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int ans = N, coupon = 0;
            while (ans >= K) {
                coupon += ans / K;
                ans = ans / K + ans % K;
            }

            System.out.println(N + coupon);
        }
    }
}