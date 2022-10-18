import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hash = new HashSet<Integer>();
		
		while(st.hasMoreTokens()) {
			hash.add(Integer.parseInt(st.nextToken()));
		}
		br.readLine();
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			if(hash.contains(Integer.parseInt(st.nextToken()))) {
				System.out.print("1 "); 
			}
			else System.out.print("0 ");
		}
	}

}