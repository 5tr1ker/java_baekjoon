import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		int increase[] = new int[N + 1];
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0; i <= N; i++)
			map.add(new ArrayList<Integer>());
			
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map.get(x).add(y);
			increase[y]++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(increase[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			sb.append(index).append(" ");
			
			for(int point : map.get(index)) {
				increase[point]--;
				
				if(increase[point] == 0) {
					queue.offer(point);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}