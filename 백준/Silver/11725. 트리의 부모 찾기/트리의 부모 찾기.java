import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		int arr[] = new int[N + 1];
		for(int i = 1; i <= N + 1; i++) {
			data.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			data.get(X).add(Y);
			data.get(Y).add(X);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		arr[1] = 1;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			
			for(int item : data.get(index)) {
				if(arr[item] == 0) {
					arr[item] = index;
					queue.add(item);
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}

}