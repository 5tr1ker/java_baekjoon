import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Long> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		Long N = Long.parseLong(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new ArrayList<Long>();
		
		arr.add(N); // 초기 0 번 Index에 
		
		int ans = 0;
		while(true) {
			merges();
			
			if(K >= totalCount()) {
				break;
			} else {
				arr.set(0, arr.get(0) + 1);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void merges() {
		for(int i = 0; i < arr.size(); i++) {
			Long amount = arr.get(i);
			arr.set(i, amount % 2);
			
			if(amount <= 1)
				break;
			
			if(i + 1 >= arr.size()) { // 배열 확장 필요
				arr.add(amount / 2);
			} else { // 이미 배열이 존재한다면?
				arr.set(i + 1, arr.get(i + 1) + amount / 2);
			}
		}
	}
	
	public static int totalCount() {
		int result = 0;
		for(int i = 0; i < arr.size(); i++) {
			result += arr.get(i);
		}
		
		return result;
	}
	
}