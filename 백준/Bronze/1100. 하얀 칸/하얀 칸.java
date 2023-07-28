import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[][] = new String[8][8];

        for(int i = 0; i < 8; i++) {
            String input[] = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                arr[i][j] = input[j];
            }
        }

        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = (i % 2) ; j < 8; j += 2) {
                if(arr[i][j].equals("F")) {
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}