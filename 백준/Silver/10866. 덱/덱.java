import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		Deque<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			if(str[0].equals("push_front")) {
				queue.addFirst(Integer.parseInt(str[1]));
			} else if(str[0].equals("push_back")) {
				queue.addLast(Integer.parseInt(str[1]));
			} else if(str[0].equals("pop_front")) {
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.pollFirst() + "\n");
			} else if(str[0].equals("pop_back")) {
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.pollLast() + "\n");
			} else if(str[0].equals("size")) {
				sb.append(queue.size() + "\n");
			} else if(str[0].equals("empty")) {
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			} else if(str[0].equals("front")) {
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.peekFirst() + "\n");
			} else if(str[0].equals("back")) {
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(queue.peekLast() + "\n");
			} 
		}
		System.out.println(sb);
	}

}