import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data[] = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int total = Integer.parseInt(data[0]);
		int term = Integer.parseInt(data[1]);
		
		for(int i = 1; i <= total; i++) queue.add(i);
		
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < term - 1; i++) {
				int queue_data = queue.poll();
				queue.add(queue_data);
			}
			
			int queue_data2 = queue.poll();
			sb.append(queue_data2 + ", ");
		}
		
		sb.delete(sb.length() - 2 , sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}