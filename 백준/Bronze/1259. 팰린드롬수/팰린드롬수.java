import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            boolean flag = true;

            if(str.equals("0")) {
                break;
            }

            for(int i = 0; i < str.length() / 2; i++) {
                if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    System.out.println("no");
                    flag = false;
                    break;
                }
            }

            if(flag) {
                System.out.println("yes");
            }
        }
    }
}