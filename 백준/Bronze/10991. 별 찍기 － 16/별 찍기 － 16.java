import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - i - 1; j++) {
                System.out.printf(" ");
            }

            for(int j = 0; j <= i; j++) {
                System.out.printf("*");
                System.out.printf(" ");
            }

            System.out.println();
        }
    }
}