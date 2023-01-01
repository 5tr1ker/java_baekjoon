import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int arr[] = new int[10];
		for(int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - '0';
			if(idx == 6 || idx == 9) {
				if(arr[6] > arr[9]) {
					arr[9]++;
				} else {
					arr[6]++;
				}
			} else {
				arr[idx]++;				
			}
		}
		
		int max = 0;
		for(int i = 0; i < 10; i++) {
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(max);
	}
	
}