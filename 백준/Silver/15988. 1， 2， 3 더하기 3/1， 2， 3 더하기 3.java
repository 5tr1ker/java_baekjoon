import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TS = Integer.parseInt(br.readLine());
        
        int arr[] = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i <= 1000000; i++) {
        	arr[i] = ((arr[i - 3] + arr[i - 2]) % 1_000_000_009 + arr[i - 1]) % 1_000_000_009;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int ttt = 0 ; ttt < TS; ttt++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	sb.append(arr[N]).append("\n");
        }
        System.out.println(sb);
	}
	
	
}