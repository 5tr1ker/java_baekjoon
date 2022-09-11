import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int M = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);
		
		HashSet<String> hash = new HashSet<String>();
		for(int i = 0; i < M; i++) {
			hash.add(br.readLine());
		}
		
		int count = 0;
		for(int j = 0; j < S; j++) {
			String str2 = br.readLine();
			if(hash.contains(str2)) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}