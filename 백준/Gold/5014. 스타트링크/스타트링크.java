import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[F + 1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		arr[S] = 1;
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			if(G == S) {
				System.out.println(arr[S] - 1);
				return;
			}
			
			if(data + U <= F && arr[data + U] == 0) {
				arr[data + U] = arr[data] + 1;
				queue.add(data + U);
			}
			if(data - D > 0 && arr[data - D] == 0) {
				arr[data - D] = arr[data] + 1;
				queue.add(data - D);
			}
		}
		
		if(arr[G] == 0) System.out.println("use the stairs");
		else System.out.println(arr[G] - 1);
		
	}
}