import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int z = 0; z < N; z++) {
            String input[] = br.readLine().split("-");

            int result = solution(input[0]);
            if(Math.abs(result - Integer.parseInt(input[1])) <= 100) {
                System.out.println("nice");

                continue;
            }
            System.out.println("not nice");
        }
    }

    public static int solution(String input) {
        int ans = 0;
        for(int i = 2; i >= 0; i--) {
            char ch = input.charAt(2 - i);

            ans += ( ch - 'A' ) * Math.pow(26 , i);
        }

        return ans;
    }
}
