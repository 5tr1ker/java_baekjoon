import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[] = new String[N];
		int arr[] = new int[26];
		int i;
		long total = 0;
		
		for(i = 0; i < N; i++) {
			str[i] = br.readLine();
			for(int j = 0; j < str[i].length() ; j++) {
				arr[(int)str[i].charAt(j) - 'A'] += (int) Math.pow(10 , str[i].length() - j) / 10;
			}
		}
		
		Arrays.sort(arr);
		
		for(int j = 25; j > 15 ; j--) {
			total += arr[j] * (j - 16);
		}
		
		System.out.println(total);
	}
}