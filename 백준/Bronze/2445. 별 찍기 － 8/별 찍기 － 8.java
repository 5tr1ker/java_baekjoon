import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                System.out.printf("*");
            }

            for(int j = 0; j < (N - i) * 2; j++) {
                System.out.printf(" ");
            }

            for(int j = 0; j < i; j++) {
                System.out.printf("*");
            }

            System.out.println(" ");
        }

        for(int i = 0; i < N * 2; i++) {
            System.out.printf("*");
        }
        System.out.println();

        for(int i = N - 1; i >= 0 ; i--) {
            for(int j = 0; j < i; j++) {
                System.out.printf("*");
            }

            for(int j = 0; j < (N - i) * 2; j++) {
                System.out.printf(" ");
            }

            for(int j = 0; j < i; j++) {
                System.out.printf("*");
            }

            System.out.println(" ");
        }
    }
}