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
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            int ipt = Integer.parseInt(st.nextToken());

            if(ipt == N) cnt++;
        }

        System.out.println(cnt);

    }
}