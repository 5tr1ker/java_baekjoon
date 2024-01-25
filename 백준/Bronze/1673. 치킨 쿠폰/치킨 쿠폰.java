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
            int coupon = N , prev = 0;

            while(coupon >= K) {
                N += coupon / K;
                prev = coupon / K;
                coupon %= K;
                coupon += prev;
            }

            System.out.println(N);
        }
    }
}