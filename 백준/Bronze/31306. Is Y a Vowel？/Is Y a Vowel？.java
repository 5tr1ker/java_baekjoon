import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ans1 = 0;
        int ans2 = 0;

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans1++;
                ans2++;
            }

            if(ch == 'y') {
                ans2++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
