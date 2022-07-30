import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		int line = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int bundle = Integer.MAX_VALUE , individually = Integer.MAX_VALUE;
		int price = 0 , i;
		for(i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine() , " ");
			bundle = Math.min(Integer.parseInt(st.nextToken()) , bundle);
			individually = Math.min(Integer.parseInt(st.nextToken()) , individually);
		}
		
		while(line > 0) {
			if(line < 6) {
				if(individually * line >= bundle) {
					price += bundle;
				} else {
					price += individually * line;
				}
				break;
			}
			else if(individually * 6 > bundle) {
				price += bundle;
				line -= 6;
			} else {
				price += individually * 6;
				line -= 6;
			}
		}
		System.out.println(price);
	}
}