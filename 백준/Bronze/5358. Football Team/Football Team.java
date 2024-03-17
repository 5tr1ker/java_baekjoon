import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input == null) {
                break;
            }

            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == 'i') {
                    sb.append("e");
                }
                else if(input.charAt(i) == 'e') {
                    sb.append("i");
                }
                else if(input.charAt(i) == 'I') {
                    sb.append("E");
                }
                else if(input.charAt(i) == 'E') {
                    sb.append("I");
                } else {
                    sb.append(input.charAt(i));
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}