import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int idx;
	int prev;
	int cnt;
	
	public Point(int idx , int prev , int cnt) {
		this.idx = idx;
		this.prev = prev;
		this.cnt = cnt;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		Point arr[] = new Point[100001];
		boolean check[] = new boolean[100001];
		Queue<Point> queue = new LinkedList<Point>();
		arr[N] = new Point(N , -1 , 0);
		queue.offer(arr[N]);
		check[N] = true;
		
		while(!queue.isEmpty()) {
			Point data = queue.poll();
			
			if(data.idx + 1 <= 100000 && !check[data.idx + 1]) {
				arr[data.idx + 1] = new Point(data.idx + 1 , data.idx , data.cnt + 1);
				queue.offer(new Point(data.idx + 1 , data.idx , data.cnt + 1));
				check[data.idx + 1] = true;
			}
			if(data.idx - 1 >= 0 && !check[data.idx - 1]) {
				arr[data.idx - 1] = new Point(data.idx - 1 , data.idx , data.cnt + 1);
				queue.offer(new Point(data.idx - 1 , data.idx , data.cnt + 1));
				check[data.idx - 1] = true;
			}
			if(data.idx * 2 <= 100000 && !check[data.idx * 2]) {
				arr[data.idx * 2] = new Point(data.idx * 2 , data.idx , data.cnt + 1);
				queue.offer(new Point(data.idx * 2 , data.idx , data.cnt + 1));
				check[data.idx * 2] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		sb.append(arr[K].cnt).append("\n");
		stack.push(K);
		
		int tmp = K;
		for(; ;) {
			tmp = arr[tmp].prev;
			
			if(tmp == -1) {
				break;
			}
			stack.push(tmp);
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop()).append(" ");
		
		System.out.println(sb);
	}
}