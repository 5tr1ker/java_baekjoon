import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0 , k , Min = 0;
		for(int i = M; i <= N; i++) {
			for(k = 2; k < i ; k++) {
				if(i % k == 0) {
					break;
				}
			}
			if(k == i) {
				if(sum == 0) {
					Min = i;
				}
				sum += i;
			}
		}
		if(sum == 0) System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(Min);
		}
	}
}
