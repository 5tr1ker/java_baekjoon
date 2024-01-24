import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long dot = 1;
        long sum = 4;
        for(int i = 1; i <= N; i++ , sum += 3) {
            dot += sum;
        }

        System.out.println(dot % 45678);
        // 1 5 ( + 4 ) , 2 12 ( + 7 ) , 3 22 ( + 10 ) , 4 35 ( + 13 )
        //
    }
}