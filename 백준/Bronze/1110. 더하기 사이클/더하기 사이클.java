import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N < 10) {
            N *= 10;
        }

        int cnt = 0;
        int prev = N;

        do {
            cnt += 1;

            int sum = (prev % 10) + (prev / 10);

            prev = (prev % 10 * 10) + sum % 10;

        } while(prev != N);

        System.out.println(cnt);
    }

}
