import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str_2 = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		int str2Length = str_2.length();
		
		for(int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if(str_2.charAt(str2Length - 1) == str.charAt(i)) {
				for(int j = 1; j <= str2Length && str2Length < str.length(); j++) {
					if(sb.length() - str2Length < 0) continue;
					if(sb.charAt(sb.length() - j) != str_2.charAt(str2Length - j)) break;
					if(j == str2Length) sb.delete(sb.length() - str2Length , sb.length());
				}
			}
		}
		
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}
}