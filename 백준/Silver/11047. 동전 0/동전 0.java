import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testcase = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int papermoney[] = new int[testcase];
		int count = 0;
		
		for(int i = 0; i < testcase; i++) {
			papermoney[i] = Integer.parseInt(br.readLine());
		};
		
		for(int i = testcase - 1; i >= 0; i--) {
			if(money / papermoney[i] > 0) {
				count += money / papermoney[i];
				money -= papermoney[i] * (money / papermoney[i]);
			}
		}
		
		System.out.println(count);
	}
}