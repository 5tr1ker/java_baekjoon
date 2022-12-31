import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		
		System.out.println(x1 + x2);
		System.out.println(x1 - x2);
		System.out.println(x1 * x2);
		System.out.println(x1 / x2);
		System.out.println(x1 % x2);
	}
	
}