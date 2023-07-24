import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(i % 2 == 1) {
                System.out.printf(" ");
            }
            for(int j = 0; j < N; j++) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}