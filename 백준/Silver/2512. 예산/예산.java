import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int ecom = Integer.parseInt(br.readLine());
		
		int min = 0 , max = 0;
		boolean flag = false;
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		while(max > min) {
			int half = (max + min) / 2;
			
			if(count(half) > ecom) {
				flag = true;
				max = half;
			} else {
				min = half + 1;
			}
		}
		
		if(flag) System.out.println(min - 1);
		else System.out.println(min);
	}

	public static int count(int half) {
		int index = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= half) {
				index += half;
			} else {
				index += arr[i];
			}
		}
		
		return index;
	}
	
}