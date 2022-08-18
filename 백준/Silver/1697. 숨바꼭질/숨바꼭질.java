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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[100000 + 1];

		int index;
		
		if(N == K) {
			System.out.println("0");
			return;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		
		while(!queue.isEmpty()) {
			index = queue.poll();
			
			if(index + 1 < arr.length && arr[index + 1] == 0) {
				arr[index + 1] = arr[index] + 1;
				queue.add(index + 1);
			}
			
			if(index - 1 >= 0 && arr[index - 1] == 0) {
				arr[index - 1] = arr[index] + 1;
				queue.add(index - 1);
			}
			
			if(index * 2 < arr.length && arr[index * 2] == 0) {
				arr[index * 2] = arr[index] + 1;
				queue.add(index * 2);
			}
		}
		
		System.out.println(arr[K]);
	}

}
