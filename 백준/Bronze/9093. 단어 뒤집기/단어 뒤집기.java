import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String input[] = br.readLine().split(" ");

            for(int j = 0; j < input.length; j++) {
                String data = input[j];

                for(int z = data.length() - 1; z >= 0; z--) {
                    sb.append(data.substring(z , z + 1));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
