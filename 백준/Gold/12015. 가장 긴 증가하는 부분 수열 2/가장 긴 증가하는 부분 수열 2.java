import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> dp; // 저장될 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		dp = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp.add(arr[0]);
		for(int i = 1; i < N; i++) {
			if(dp.get(dp.size() - 1) < arr[i]) { // 만약 새로운 요소가 더 크다면?
				dp.add(arr[i]);
			}
			else {
				dp.set(findLower(arr[i]) , arr[i]);
			}
		}
		
		System.out.println(dp.size());
	}
	
	public static int findLower(int idx) {
		int start = 0;
		int end = dp.size() - 1;
		
		while(start < end) {
			int half = (start + end) / 2;
			
			if(dp.get(half) >= idx) end = half;
			else start = half + 1;
		}
		
		return start;
	}
	
}