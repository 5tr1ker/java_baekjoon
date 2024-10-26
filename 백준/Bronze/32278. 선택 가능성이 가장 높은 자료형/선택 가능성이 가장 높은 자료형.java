import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(br.readLine());

        if(input >= -32768 && input <= 32767) {
            System.out.println("short");
        } else if (input >= -2147483648 && input <= 2147483647) {
            System.out.println("int");
        } else {
            System.out.println("long long");
        }
    }
}
