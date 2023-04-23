import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        for(int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());
            total += (input < 40? 40 : input);
        }

        System.out.println(total / 5);
    }
}