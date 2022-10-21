import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			if(hash.containsKey(name)) {
				hash.put(name, 1 + hash.get(name));
			} else {
				hash.put(name, 1);
			}
		}
		
		String result = null; 
		int value = 0;
		Set<String> keys = hash.keySet();
		for(String data : keys) {
			int hashValue = hash.get(data);
			if(value < hashValue) {
				value = hashValue;
				result = data;
			}
			else if (value == hashValue) {
				if(result.compareTo(data) > 0) {
					result = data;
				}
			}
		}
		
		System.out.println(result);
	}

}