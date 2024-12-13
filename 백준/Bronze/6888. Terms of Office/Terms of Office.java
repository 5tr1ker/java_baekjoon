import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        for(int i = 0; i <= end - start; i++) {
            if(i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0) {
                System.out.println("All positions change in year " + (start + i));
            }
        }
    }
}
