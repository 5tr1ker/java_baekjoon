import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int a = Integer.parseInt(st.nextToken());
            if(a == 0) {
                break;
            }

            int line = 1;
            for(int i = 0; i < a; i++) {
                int input1 = Integer.parseInt(st.nextToken());

                line *= input1;

                int input2 = Integer.parseInt(st.nextToken());
                line -= input2;
            }

            sb.append(line).append("\n");
        }

        System.out.println(sb);

    }
}