import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        BigInteger big = new BigInteger("0");

        for(long i = 1; i < N; i++) {
            big = big.add(new BigInteger(String.valueOf(N * i + i)));
        }

        System.out.println(big);
    }
}