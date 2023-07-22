import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TS = Integer.parseInt(br.readLine());

        while(TS-- > 0) {
            int input = Integer.parseInt(br.readLine());

            int cnt = 0;
            while(input >= 1) {
                if(input % 2 != 0) {
                    System.out.printf("%d " , cnt);
                }

                input /= 2;
                cnt++;
            }
        }
    }
}