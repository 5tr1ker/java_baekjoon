import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , "- , +" , true);
		int Num[] = new int[50];
		String Token;
		int i = 0 , total = 0;
		
		while(st.hasMoreTokens()) {
			Token = st.nextToken();
			while(Token.contains("-")) {
				total -= Integer.parseInt(st.nextToken());
				if(!st.hasMoreTokens()) break;
				Token = st.nextToken();
				while(Token.contains("+")) {
					total -= Integer.parseInt(st.nextToken());
					if(!st.hasMoreTokens()) break;
					Token = st.nextToken();
				}
			}
			if(!Token.matches("[+-]")) {
				Num[i] = Integer.parseInt(Token);
				i++;
			}
		}
		
		for(int Number : Num) {
			total += Number;
		}
		
		System.out.println(total);
	}

}
