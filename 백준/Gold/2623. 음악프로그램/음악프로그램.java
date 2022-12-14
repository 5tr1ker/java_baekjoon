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
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int increase[] = new int[N + 1];
		for(int i = 0; i <= N ; i++)
			map.add(new ArrayList<Integer>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int K = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j = 1; j < K; j++) {
				int next = Integer.parseInt(st.nextToken());
				map.get(prev).add(next);
				increase[next]++;
				prev = next;
			}
		}
		
		for(int i = 1; i <= N ; i++) {
			if(increase[i] == 0)
				queue.offer(i);
		}
		
		int check = queue.size();
		while(!queue.isEmpty()) {
			int data = queue.poll();
			sb.append(data).append("\n");
			
			for(int idx : map.get(data)) {
				increase[idx]--;
				
				if(increase[idx] == 0) {
					queue.offer(idx);
					check++;
				}
			}
		}
		
		if(check != N) System.out.println(0);
		else System.out.println(sb);
		
	}

}