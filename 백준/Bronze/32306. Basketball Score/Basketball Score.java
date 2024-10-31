import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 3; i++) {
            a += Integer.parseInt(st.nextToken()) * ( i + 1 );
            b += Integer.parseInt(st2.nextToken()) * ( i + 1 );
        }

        if(a == b) {
            System.out.println(0);
        } else if(a > b) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
