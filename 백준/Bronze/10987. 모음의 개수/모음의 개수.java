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
        String str[] = br.readLine().split("");
        int count = 0;

        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o") || str[i].equals("u") ) {
                count++;
            }
        }

        System.out.println(count);
    }
}