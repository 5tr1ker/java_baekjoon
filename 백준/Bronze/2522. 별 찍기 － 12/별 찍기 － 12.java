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
            for(int j = 1; j < N - i ; j++) {
                System.out.printf(" ");
            }

            for(int j = 0; j <= i ; j++) {
                System.out.printf("*");
            }

            System.out.println();
        }

        for(int i = N - 2; i >= 0; i--) {
            for(int j = 1; j < N - i ; j++) {
                System.out.printf(" ");
            }

            for(int j = 0; j <= i ; j++) {
                System.out.printf("*");
            }

            System.out.println();

        }
    }
}