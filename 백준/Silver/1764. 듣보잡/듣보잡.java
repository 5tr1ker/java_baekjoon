import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> list = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			
			if(list.contains(str)) {
				count++;
				result.add(str);
			}
		}
		
		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) sb.append(result.get(i) + "\n");
		
		System.out.println(count);
		System.out.println(sb);
	}

}