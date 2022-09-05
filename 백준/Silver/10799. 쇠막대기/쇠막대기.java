import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int count = 0;
		int pipe = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				count++;
				pipe++;
			} else if (str.charAt(i) == ')' && str.charAt(i - 1) == '(') { // 레이저
				pipe--; count--;
				count += pipe;
			} else { // 파이프 닫기
				pipe--;
			}
		}
		System.out.println(count);
	}
}
