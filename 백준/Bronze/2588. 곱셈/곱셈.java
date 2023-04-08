import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input1 = Integer.parseInt(br.readLine());
        int input2 = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append(input1 * (input2 % 10)).append("\n");
        sb.append(input1 * (input2 % 100 / 10)).append("\n");
        sb.append(input1 * (input2 / 100)).append("\n");
        sb.append(input1 * input2).append("\n");
        System.out.println(sb);
    }
}
