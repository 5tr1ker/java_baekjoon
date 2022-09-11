import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();
		
		minQueue.add(Integer.parseInt(br.readLine()));
		sb.append(minQueue.peek() + "\n");
		
		for(int i = 1; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			
			if(minQueue.size() == maxQueue.size()) {
				minQueue.add(index);
			} else {
				maxQueue.add(index);
			}
			
			if(minQueue.peek() > maxQueue.peek()) {
				int temp = minQueue.poll();
				minQueue.add(maxQueue.poll());
				maxQueue.add(temp);
			}
			
			sb.append(minQueue.peek() > maxQueue.peek() ? maxQueue.peek() : minQueue.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}
