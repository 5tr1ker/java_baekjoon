import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == ' ' || (ch >= 0 && ch <= 9)) {
                sb.append(ch);

                continue;
            }

            // A B C D E F G H I Z K L K O P Q R S a b c d e f g h i z k l k o p q r s
            if(ch <= 'Z' && ch >= 'A') {
                if(ch + 13 > 'Z') {
                    ch -= 26;

                    sb.append(Character.toString(ch + 13));
                } else {
                    sb.append(Character.toString(ch + 13));
                }
            } else if(ch <= 'z' && ch >= 'a') {
                if(ch + 13 > 'z') {
                    ch -= 26;

                    sb.append(Character.toString(ch + 13));
                } else {
                    sb.append(Character.toString(ch + 13));
                }
            } else {
                sb.append(Character.toString(ch));
            }
        }

        System.out.println(sb);
    }

}