import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int startX , startY , destX , destY;
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int testcase = 0; testcase < test; testcase++) {
			int count_store = Integer.parseInt(br.readLine());
			List<int []> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			startX = x;
			startY = y; // 시작점
			
			for(int i = 0; i < count_store; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x , y});
			}
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			destX = x;
			destY = y; // 시작점
			
			Queue<int []> queue = new LinkedList<int[]>();
			boolean check[] = new boolean[count_store];
			queue.add(new int[] {startX , startY});
			
			while(true) {
				if(queue.isEmpty()) {
					System.out.println("sad");
					break;
				}
				
				int data[] = queue.poll(); // 현재 위치
				int cx = data[0];
				int cy = data[1];
				
				if(Math.abs(destY - cy) + Math.abs(destX - cx) <= 1000) {
					System.out.println("happy");
					break;
				}
				
				for(int i = 0; i < list.size(); i++ ) {
					int px = list.get(i)[0];
					int py = list.get(i)[1];
					
					if(!check[i] && Math.abs(cx - px) + Math.abs(cy - py) <= 1000) {
						queue.add(new int[] {px , py});
						check[i] = true;
					}
				}
			}
		}
	}

}