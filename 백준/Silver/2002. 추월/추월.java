import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for(int i = 0; i < N; i++) {
			hash.put(br.readLine(), i);
		}
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = hash.get(br.readLine());
		}
		
		int ans = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] > arr[j]) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}