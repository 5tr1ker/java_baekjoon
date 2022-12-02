import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int time;
	int x;
	
	public Point(int x , int time) {
		this.x = x;
		this.time = time;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		boolean check[] = new boolean[100001];
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(N , 0));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			check[point.x] = true;
			
			if(point.x == K) min = Math.min(point.time, min);
			if(point.x * 2 < check.length && !check[point.x * 2]) queue.offer(new Point(point.x * 2 , point.time));
			if(point.x + 1 < check.length && !check[point.x + 1]) queue.offer(new Point(point.x + 1 , point.time + 1));
			if(point.x - 1 >= 0 && !check[point.x - 1]) queue.offer(new Point(point.x - 1, point.time + 1));
		}
		
		System.out.println(min);
	}

}
