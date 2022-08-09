import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char []char_str = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		Arrays.sort(char_str);
		
		char Center = ' ';
		for(int i = 0; i < char_str.length; i++) {
			if(i + 1 < char_str.length && char_str[i] == char_str[i + 1]) {
				sb = sb.append(char_str[i]);
				i++;
			}
			else if(Center == ' ') {
				Center = char_str[i];
			} else {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		
		StringBuilder reversversion = new StringBuilder(sb);
		reversversion.reverse();
		
		if(Center == ' ') System.out.printf("%s%s" , sb , reversversion);
		else System.out.printf("%s%c%s" , sb , Center , reversversion);
	}
}
