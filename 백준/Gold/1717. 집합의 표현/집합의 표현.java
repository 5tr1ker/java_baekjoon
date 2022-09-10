import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int arr[];
	
	public static int find(int x) {
		if(arr[x] == x) return x;
		else return arr[x] = find(arr[x]);
	}

	public static void union(int x , int y) {
		arr[y] = x;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		arr = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int data1 = Integer.parseInt(st.nextToken());
			int data2 = Integer.parseInt(st.nextToken());
			int data3 = Integer.parseInt(st.nextToken());

			int findx = find(data2);
			int findy = find(data3);
			
			if(data1 == 0) {
				union(findx , findy);
			} else {
				if(findx == findy) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
}