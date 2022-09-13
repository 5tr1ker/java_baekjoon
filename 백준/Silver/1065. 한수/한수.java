import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 99) {
			System.out.println(N);
			return;
		}
		int total = 99;
		int diff = 0;
		for(int i = 100; i <= N; i++) {
			String str = String.valueOf(i);
			
			int firstNumber = Character.getNumericValue(str.charAt(0));
			int secondNumber = Character.getNumericValue(str.charAt(1));
			int thirdNumber = Character.getNumericValue(str.charAt(2));
			diff = secondNumber - firstNumber;
			if(secondNumber + diff == thirdNumber) total++;
		}
		
		System.out.println(total);
	}

}