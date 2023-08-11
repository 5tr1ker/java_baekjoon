import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str[] = br.readLine().split("");

            if(str.length == 1 && str[0].equals("0")) {
                return;
            }

            int ans = 2;

            for(String string : str) {
                if(string.equals("0")) {
                    ans += 4;
                } else if(string.equals("1")) {
                    ans += 2;
                } else {
                    ans += 3;
                }
                ans += 1;
            }

            System.out.println(ans - 1);
        }
    }
}