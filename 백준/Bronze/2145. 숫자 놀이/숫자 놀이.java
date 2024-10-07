import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                return;
            }

            int temp = N;

            while(true) {
                String next[] = Integer.toString(temp).split("");

                if(next.length == 1) {
                    System.out.println(temp);

                    break;
                }

                temp = 0;
                for(String index : next) {
                    temp += Integer.parseInt(index);
                }
            }
        }
    }
}
