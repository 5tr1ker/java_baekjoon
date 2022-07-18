import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		boolean Decimal[] = new boolean[1001];
		
		for(int i = 2; i < Math.sqrt(1001); i++) {
			for(int j = i * i; j < 1001; j += i) {
				Decimal[j] = true;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		Decimal[1] = true;
		for(int i = 0; i < N; i++) {
			if(!Decimal[Integer.parseInt(st.nextToken())]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}