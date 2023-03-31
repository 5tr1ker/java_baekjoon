import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int gd[] = new int[testcase];
		int result = 0;
		
		for(int i = 0; i < testcase; i++) {
			gd[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(gd);
		result = gd[0];
		for(int i = 1; i < testcase; i++) {
			gd[i] = gd[i - 1] + gd[i];
			result += gd[i];
		}
		
		System.out.println(result);
	}

}
