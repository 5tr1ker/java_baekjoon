import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String arr[] = new String[75];

        for(int i = 0; i < 5; i++) {
            String[] input = br.readLine().split("");

            for(int j = 0; j < input.length; j++) {
                arr[i + (5 * j)] = input[j];
            }
        }

        for(String str : arr) {
            if(str != null && !str.isEmpty()) {
                sb.append(str);
            }
        }

        System.out.println(sb);
    }
}