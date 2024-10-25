import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();

            if(str.contains("w")) {
                System.out.println("chunbae");

                return;
            } else if(str.contains("b")) {
                System.out.println("nabi"); return;
            } else if(str.contains("g")) {
                System.out.println("yeongcheol"); return;
            }
        }
    }
}
