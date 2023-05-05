import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hamburgerPrice = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i++) {
            hamburgerPrice = Math.min(hamburgerPrice , Integer.parseInt(br.readLine()));
        }

        int drinkPrice = Integer.MAX_VALUE;
        for(int i = 0; i < 2; i++) {
            drinkPrice = Math.min(drinkPrice , Integer.parseInt(br.readLine()));
        }

        System.out.println(hamburgerPrice + drinkPrice - 50);
    }
}