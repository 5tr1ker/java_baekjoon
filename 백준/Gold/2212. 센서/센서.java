import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sensior = Integer.parseInt(br.readLine());
		int center = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int sensior_arr[] = new int[sensior];
		for(int i = 0; i < sensior ; i++) {
			sensior_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensior_arr);
		
		int diff[] = new int[sensior - 1];
		int total = 0;
		for(int i = 0; i < sensior - 1; i++) {
			diff[i] = sensior_arr[i + 1] - sensior_arr[i];
		}
		
		Arrays.sort(diff);
		
		for(int i = 0; i  < sensior - center ; i++) {
			total += diff[i];
		}
		System.out.println(total);
		
	}
}
