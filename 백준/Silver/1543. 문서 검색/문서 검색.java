import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a1 = br.readLine();
		String a2 = br.readLine();
		
		String b1 = a1.replace(a2 , "");
		
		System.out.println((a1.length() - b1.length()) / a2.length());
	}
}