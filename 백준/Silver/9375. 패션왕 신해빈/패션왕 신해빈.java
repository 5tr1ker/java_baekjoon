import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int z = 0; z < N; z++) {
			
			HashMap<String, Integer> hash = new HashMap<String, Integer>();
			int amount = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < amount; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				@SuppressWarnings("unused")
				String unuseValue = st.nextToken();
				String kind = st.nextToken();
				if(hash.containsKey(kind)) {
					hash.put(kind , hash.get(kind) + 1);
				}
				else hash.put(kind , 1);
			}
			
			int total = 1;
			Set<String> data = hash.keySet();
			for(String keys : data) {
				total *= hash.get(keys) + 1;
			}
			
			sb.append((total - 1) + "\n");
			
		}
		System.out.println(sb);
	}

}