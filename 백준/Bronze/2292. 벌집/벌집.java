import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1 , 2 ~ 7 , 8 ~ 19 , 20 ~ 37 , 38 ~ 61
        int range = 7;

        if(N == 1) {
            System.out.println(1);
            return;
        }

        for(int i = 1; ; i++ ) {

            if(N <= range) {
                System.out.println(i + 1);

                break;
            }

            range += ( 6 * (i + 1) );
        }
    }
}