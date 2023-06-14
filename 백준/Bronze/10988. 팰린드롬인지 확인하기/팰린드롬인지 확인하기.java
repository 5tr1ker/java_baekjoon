import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split("");

        for(int i = 0; i < str.length / 2 ; i++) {
            if(!str[i].equals(str[str.length - 1 - i])) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}