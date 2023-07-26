import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            int number = 0;
            if (!(input.equals("all") || input.equals("empty"))) {
                number = Integer.parseInt(st.nextToken());
            }

            if (input.equals("add")) {
                ans |= (1 << number);
            } else if (input.equals("remove")) {
                ans &= ~(1 << number);
            } else if (input.equals("check")) {
                sb.append((ans & (1 << number)) != 0 ? 1 : 0).append("\n");
            } else if (input.equals("toggle")) {
                ans ^= (1 << number);
            } else if (input.equals("all")) {
                ans = (1 << 31) - 1;
            } else { // empty
                ans = 0;
            }
        }

        System.out.println(sb);
    }
}