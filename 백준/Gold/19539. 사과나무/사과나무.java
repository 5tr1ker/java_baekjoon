import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int divid = 0 , namo = 0;
		for(int i = 0 ; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			divid += input / 2;
			namo += input % 2;
		}
		
		if(divid >= namo && (divid - namo) % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}

}
