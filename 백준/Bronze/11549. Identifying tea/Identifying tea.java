import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans = br.readLine();
        String input[] = br.readLine().split(" ");

        int aa = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i].equals(ans)) {
                aa ++;
            }
        }

        System.out.println(aa);
    }
}
