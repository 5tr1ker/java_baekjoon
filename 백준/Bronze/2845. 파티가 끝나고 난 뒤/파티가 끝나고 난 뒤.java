import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a[] = br.readLine().split(" ");

        int aa = Integer.parseInt(a[0]) * Integer.parseInt(a[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) {
            System.out.printf("%d " , Integer.parseInt(st.nextToken()) - aa);
        }
    }
}