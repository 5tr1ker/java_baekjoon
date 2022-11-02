import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		int rate = (int)((long)Y*100/X);
		int min = 0;
		int max = 1000000000;
		
		while(max >= min) {
			int half = (max + min) / 2;
			
			int changeRate = (int)(((long)Y + half) * 100 /(X + half));
			if(changeRate != rate) {
				max = half - 1;
			} else {
				min = half + 1;
			}
		
		}
		
		if(max == 1000000000) {
			System.out.println("-1");
			return;
		}
		System.out.println( min );
	}
	
}