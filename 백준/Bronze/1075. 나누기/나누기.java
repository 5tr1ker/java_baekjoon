import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = (N / 100) * 100;
        int ans = 0;
        while(true) {
            if(N % F == 0) {
                break;
            }
            N++;
            ans++;
        }

        String str = Integer.toString(ans);
        System.out.println(("0" + str).substring(str.length() - 1 , str.length() + 1));
    }
}