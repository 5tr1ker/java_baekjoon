import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int ans = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		while(true) {
			int calcul = N + ans;
			int count = 0;
			
			while(calcul > 0) {
				if(calcul % 2 != 0)
					count++;
				
				calcul /= 2;
			}
			
			if(count <= K)
				break;
			ans++;
		}
		
		System.out.println(ans);
	}
	
}