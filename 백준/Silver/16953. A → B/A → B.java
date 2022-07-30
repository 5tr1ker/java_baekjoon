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
		String strB = null;
		
		while(A != B) {
			strB = Long.toString(B);
			if(A > B) {
				count = -1;
				break;
			}
			if(B % 2 == 0) {
				count++;
				B /= 2;
			} else if (strB.charAt(strB.length() - 1) == '1') {
				B = Long.parseLong(strB.substring(0, strB.length() - 1));
				count++;
			} else {
				count = -1;
				break;
			}
		}
		
		System.out.println(count);
	}

}
