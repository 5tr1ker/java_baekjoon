import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static public ArrayList<Integer> arr[];
	static public char type[];
	static public int amount[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		type = new char[N + 1];
		amount = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		
		for(int i = 2; i <= N ; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			char types = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			int vertex = Integer.parseInt(st.nextToken());
			
			arr[vertex].add(i);
			amount[i] = num;
			type[i] = types;
		}
		
		long result = dfs(1);
		System.out.println(result);
		
	}
	
	public static long dfs(int index) {
		if(arr[index].size() == 0) { // 리프 노드일 때
			if(type[index] == 'W') { // 늑대이면
				return 0;
			} else { // 양이면 그 개체를 반환
				return amount[index];
			}
		}
		
		long cnt = 0;
		for(int vertex : arr[index]) {
			cnt += dfs(vertex);
		}
		
		if(type[index] == 'W') {
			return Math.max(0, cnt - amount[index]);
		} else {
			return cnt + amount[index];
		}
		
	}

}