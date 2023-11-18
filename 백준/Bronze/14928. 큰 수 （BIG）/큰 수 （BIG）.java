import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String input = br.readLine();

        int remain = 0;
        for(int i = 0; i < input.length(); i++) {
            remain = (( 10 * remain ) + (input.charAt(i) - '0')) % 20000303;
        }

        System.out.println(remain);
    }
}