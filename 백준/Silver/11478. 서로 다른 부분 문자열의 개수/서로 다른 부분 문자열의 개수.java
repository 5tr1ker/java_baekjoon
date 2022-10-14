import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashSet<String> hash = new HashSet<String>();
		
		String index = null;
		for(int i = 0; i < str.length(); i++) {
			index = "";
			for(int j = i; j < str.length(); j++) {
				index += str.charAt(j);
				hash.add(index);
			}
		}
		
		System.out.println(hash.size());
	}
}