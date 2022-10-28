import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		int idx = Integer.MAX_VALUE;
		for(int i = 0; i <= b.length() - a.length(); i++) {
			int data = 0;
			for(int j = 0; j < a.length() ; j++) {
				if(b.charAt(i + j) != a.charAt(j)) {
					data++;
				}
			}
			idx = Math.min(idx, data);
		}
		
		System.out.println(idx);
	}

}