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
		ArrayList<Integer>[] arr = new ArrayList[N + 1]; // 위상 정렬 리스트
		int result[] = new int[N + 1]; // 결과값
		int increase[] = new int[N + 1]; // 위상 정렬
		int time[] = new int[N + 1]; // 걸리는 시간
		
		for(int i = 1; i<= N; i++)
			arr[i] = new ArrayList<Integer>();
		
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int idx = Integer.parseInt(st.nextToken());
				
				if(idx == -1) break;
				
				arr[idx].add(i);
				increase[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			if(increase[i] == 0) {
				queue.add(i);
				result[i] = time[i];
			}
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			for(int idx : arr[data]) {
				increase[idx]--;
				
				result[idx] = Math.max(result[idx], result[data] + time[idx]);
				
				if(increase[idx] == 0) {
					queue.add(idx);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++)
			sb.append(result[i]).append("\n");
		
		System.out.println(sb);
	}
}