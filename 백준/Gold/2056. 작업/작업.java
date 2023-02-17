import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		int increase[] = new int[N + 1];
		int increaseWeight[] = new int[N + 1];

		int weight[] = new int[N + 1];
		int ans = 0;
		for(int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			 st = new StringTokenizer(br.readLine() , " ");
			 weight[i] = Integer.parseInt(st.nextToken());
			 
			 int M = Integer.parseInt(st.nextToken());
			 for(int j = 0; j < M; j++) {
				 int idx = Integer.parseInt(st.nextToken());
				 arr[idx].add(i);
				 increase[i]++;
			 }
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(increase[i] == 0) {
				queue.offer(i);				
				increaseWeight[i] = weight[i];
			}			
		}
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			for(int idx : arr[data]) {
				increase[idx]--;
				increaseWeight[idx] = Math.max(increaseWeight[idx], weight[idx] + increaseWeight[data]);
				
				if(increase[idx] == 0) {
					queue.offer(idx);
				}
			}
		}
		
		for(int i = 1; i <= N; i++)
			ans = Math.max(ans, increaseWeight[i]);
		
		System.out.println(ans);
	}
	
}