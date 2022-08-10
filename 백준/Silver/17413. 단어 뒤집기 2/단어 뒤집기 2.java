import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine() , "<> " , true);
		
		StringBuffer sb;
		boolean isChange = true;
		String str;
		
		while(st.hasMoreTokens()) {
			str = st.nextToken();
			if(str.equals("<")) {
				isChange = false;
			} else if (str.equals(">")) {
					isChange = true;
			}
			
			if(!isChange) {
				System.out.printf("%s" , str);
			} else {
				sb = new StringBuffer(str);
				System.out.printf("%s" , sb.reverse().toString());
			}
		}
	}

}
