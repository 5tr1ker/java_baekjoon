import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[26];

        for(int i = 0; i < N; i++) {
            char ch = br.readLine().charAt(0);

            arr[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(arr[i] >= 5) {
                sb.append(Character.toString((char) ('a' + i)));
            }
        }

        if(sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }

    }
}