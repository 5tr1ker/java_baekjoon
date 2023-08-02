import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger ans = new BigInteger("0");

            for(int j = 0; j < N; j++) {
                String input[] = br.readLine().split("-");

                if(input.length > 1) {
                    ans = ans.subtract(new BigInteger(input[1]));
                } else {
                    ans = ans.add(new BigInteger(input[0]));
                }
            }

            String result[] = ans.toString().split("-");

            if(result.length > 1) {
                System.out.println("-");
            } else if(result[0].equals("0")) {
                System.out.println("0");
            } else {
                System.out.println("+");
            }
        }
    }
}