import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseUnsignedLong(br.readLine());
		
		Long result = 0L;
		// Long i = 0L;
		int i;
		for(i = 1;  ; i++) {
			if(result > N) {
				i--; break;
			}
			result += i;
		}
		
		System.out.println(i - 1);
	}

}
