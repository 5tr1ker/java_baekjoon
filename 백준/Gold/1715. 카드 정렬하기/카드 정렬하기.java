import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		long total = 0;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int temp1;
		int temp2;
		while(pq.size() > 1) {
			temp1 = pq.poll();
			temp2 = pq.poll();
			pq.add(temp1 + temp2);
			total += temp1 + temp2;
		}
		System.out.println(total);
	}
}
