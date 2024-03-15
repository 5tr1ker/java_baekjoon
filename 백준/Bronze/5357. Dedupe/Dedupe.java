import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
char ch = ' ';
String input = br.readLine();
for(int j=0;j<input.length();j++) {
if(input.charAt(j) == ch) {continue;}ch=input.charAt(j);sb.append(input.charAt(j));}sb.append("\n");}

        System.out.println(sb);
    }

}