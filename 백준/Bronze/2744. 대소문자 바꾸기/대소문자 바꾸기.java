import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isUpperCase(ch)) {
                System.out.print(Character.toLowerCase(ch));
            }else {
                System.out.print(Character.toUpperCase(ch));
            }
        }
    }
}