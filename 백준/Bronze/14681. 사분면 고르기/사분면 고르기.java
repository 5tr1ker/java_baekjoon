import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean x = Integer.parseInt(br.readLine()) > 0;
        boolean y = Integer.parseInt(br.readLine()) > 0;

        if(x) {
            if(y) {
                System.out.println(1);
            } else {
                System.out.println(4);
            }
        } else {
            if(y) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}