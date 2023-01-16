import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int arr[] = new int[N];
		dp = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp.add(arr[0]);
		for(int i = 1; i < N; i++) {
			if(dp.get(dp.size() - 1) < arr[i]) {
				dp.add(arr[i]);
			}
			else {
				dp.set(lowerBound(arr[i]), arr[i]);
			}
		}
		
		System.out.println(dp.size());
	}
	
	public static int lowerBound(int idx) {
		int start = 0;
		int end = dp.size() - 1;
		
		while(end > start) {
			int half = (start + end) / 2;
			
			if(dp.get(half) < idx) start = half + 1;
			else end = half;
		}
		return start;
	}
	
}