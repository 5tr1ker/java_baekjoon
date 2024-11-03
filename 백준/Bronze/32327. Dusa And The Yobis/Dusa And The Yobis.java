import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int init = Integer.parseInt(br.readLine());

        while(true) {
            int next = Integer.parseInt(br.readLine());

            if(next >= init) {
                System.out.println(init);

                return;
            }

            init += next;
        }
    }
}
