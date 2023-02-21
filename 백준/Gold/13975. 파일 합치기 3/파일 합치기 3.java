import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TS = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(TS-- > 0) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Long total = 0L;
			PriorityQueue<Long> queue = new PriorityQueue<>();
			
			for(int i = 0; i < K; i++) {
				queue.offer(Long.parseLong(st.nextToken()));
			}
			
			while(queue.size() > 1) {
				Long idx1 = queue.poll();
				Long idx2 = queue.poll();
				
				total += idx1 + idx2;
				queue.offer(idx1 + idx2);
			}
			
			sb.append(total).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}