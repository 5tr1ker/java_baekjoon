import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String secret = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if(ch == ' ') {
                sb.append(" ");

                continue;
            }

            ch -= secret.charAt(i % secret.length());
            if(ch < 97) {
                ch += 97 - 1;
            }
            while(ch < 97) {
                ch += 26;
            }

            sb.append((char) ch);
        }

        System.out.println(sb);

    }
}