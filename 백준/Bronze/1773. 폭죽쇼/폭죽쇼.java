import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int ans = 0;
        boolean check[] = new boolean[C + 1];

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            for(int j = input; j <= C; j += input) {
                if(!check[j]) {
                    check[j] = true;

                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}