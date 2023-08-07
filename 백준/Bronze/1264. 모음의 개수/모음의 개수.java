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
            String input[] = br.readLine().split("");
            int ans = 0;

            if(input.length == 1 && input[0].equals("#")) {
                return;
            }
            for(int i = 0; i < input.length; i++) {
                String str = input[i].toLowerCase();

                if(str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")) {
                    ans ++;
                }

            }
            System.out.println(ans);
        }
    }
}