import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        int idx = 1;
        for(int i = 1; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());

            if (max < input) {
                max = input;
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}