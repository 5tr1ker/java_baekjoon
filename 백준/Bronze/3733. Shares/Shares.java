import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();
            if(input == null) {
                return;
            }

            StringTokenizer st = new StringTokenizer(input , " ");

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            System.out.println(S / (N + 1));
        }

    }

}