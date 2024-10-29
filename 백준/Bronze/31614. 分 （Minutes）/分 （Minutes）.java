import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(br.readLine()) * 60;
        ans += Integer.parseInt(br.readLine());
        System.out.println(ans);
    }
}
