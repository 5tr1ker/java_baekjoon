import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            int price = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            sum += price * amount;
        }

        if(sum == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}