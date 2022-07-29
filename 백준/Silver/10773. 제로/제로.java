import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int index = 0;
		for(int i = 0; i < N; i++) {
			arr[index] = Integer.parseInt(br.readLine());
			
			if(arr[index] == 0) {
				index--;
				arr[index] = 0;
			}
			else index++;
		}
		
		int total = 0;
		for(int data : arr) {
			total += data;
		}
		System.out.println(total);
	}

}
