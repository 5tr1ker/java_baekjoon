import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= size; i++) { // 담기
			list.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 찾을 값
		}
		
		int total = 0;
		for(int i = 0; i < N; i++) {
			int locate = list.indexOf(arr[i]); // 값 위치
			int half = 0;
			
			if(list.size() % 2 == 0) half = list.size() / 2;
			else half = list.size() / 2;
			
			if(locate <= half) {
				for(int j = 0; j < locate; j++) {
					list.offerLast(list.pollFirst());
					total++;
				}
			} else {
				for(int j = 0; j < list.size() - locate ; j++) {
					list.offerFirst(list.pollLast());
					total++;
				}
			}
			
			list.pollFirst();
		}
		
		System.out.println(total);
	}
}
