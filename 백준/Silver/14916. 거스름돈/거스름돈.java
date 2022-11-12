import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int i;
		for(i = money / 5 ; i > 0 ; i--) {
			if((money - i * 5) % 2 == 0) 
				break;
		}
		if((money - i * 5) % 2 != 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(i + ((money - i * 5) / 2));
	}
}
