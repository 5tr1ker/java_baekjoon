import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int half[] = new int[5];

        for(int i = 0; i < 5; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;

            half[i] = input;
        }

        Arrays.sort(half);

        System.out.println(sum / 5+"\n"+half[2]);
    }
}