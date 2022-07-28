import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		String str;
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			if(counter(str)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean counter(String str) {
		int i;
		boolean []str_check = new boolean[26];
		
		for(i = 0; i < str.length() ; i++) {
			if(!str_check[str.charAt(i) - 97]) {
				str_check[str.charAt(i) - 97] = true;
				if(str.charAt(i) == str.charAt((i + 1) % str.length())) {
					str_check[str.charAt(i) - 97] = false;
				}
			} else {
				break;
			}
		}
		
		if(i == str.length()) return true;
		else return false;
	}
}
