import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer S = new StringBuffer(br.readLine());
		StringBuffer T = new StringBuffer(br.readLine());
		
		int Sleng = S.length();
		int Tleng = T.length();
		for(int i = Tleng; i > Sleng && i > 0; i--) {
			if(T.charAt(i - 1) == 'A') {
				T.deleteCharAt(i - 1);
			} else {
				T.deleteCharAt(i - 1);
				T.reverse();
			}
		}
		
		if(S.toString().equals(T.toString())) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}