import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sz = new StringTokenizer(br.readLine());
		long A = Long.parseLong(sz.nextToken());
		long B = Long.parseLong(sz.nextToken());
		int count = 1;
		
		while(A != B) {
			if(A > B) {
				count = -1;
				break;
			}
			if(B % 2 == 0) {
				count++;
				B /= 2;
			} else if (B % 10 == 1) {
				B /= 10;
				count++;
			} else {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}

}
