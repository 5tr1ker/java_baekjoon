import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int num_0 = 0, num_1 = 0;
		
		for(int i = 0; i < S.length() ; ) {
			if(S.charAt(i) == '1') {
				num_1++;
				while(i < S.length() && S.charAt(i) == '1') {
					i++;
				}
			} else {
				num_0++;
				while(i < S.length() && S.charAt(i) == '0') {
					i++;
				}
			}
		}
		System.out.println((num_0 >= num_1) ? num_1 : num_0 );
	}

}
