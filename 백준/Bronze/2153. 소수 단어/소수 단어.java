import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            sum += solved(input.charAt(i));
        }

        for(int i = 2; i < sum; i++) {
            if(sum % i == 0) {
                System.out.println("It is not a prime word.");

                return;
            }
        }

        System.out.println("It is a prime word.");
    }

    public static int solved(char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 1;
        }

        return ch - 'A' + 27;
    }
}
