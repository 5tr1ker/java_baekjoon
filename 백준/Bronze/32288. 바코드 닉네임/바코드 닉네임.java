import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double N = Double.parseDouble(br.readLine());
        String str = br.readLine();

        str = str.replace("I" , "i");
        str = str.replace("l", "L");
        System.out.println(str);
    }
}
