import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		while(st.hasMoreTokens()) {
			int numb = Integer.parseInt(st.nextToken());
			if(hash.containsKey(numb)) {
				hash.put(numb, hash.get(numb) + 1);
			} else {
				hash.put(numb , 1);				
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			int numb = Integer.parseInt(st.nextToken());
			if(hash.containsKey(numb)) {
				sb.append(hash.get(numb) + " ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}

}
