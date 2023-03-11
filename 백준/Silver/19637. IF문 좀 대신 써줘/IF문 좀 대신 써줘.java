import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Prefix {
	String prefix;
	int data;
	
	public Prefix(String prefix, int data) {
		super();
		this.prefix = prefix;
		this.data = data;
	}
	
	
}

public class Main {
	
	static int N , M;
	static Prefix arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new Prefix[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String prefix = st.nextToken();
			int data = Integer.parseInt(st.nextToken());
			
			arr[i] = new Prefix(prefix, data);
		}
		
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			
			sb.append(binarySearch(input)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static String binarySearch(int input) {
		int min = 0;
		int max = arr.length;
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(arr[half].data < input) {
				min = half + 1;
			} else {
				max = half;
			}
		}
		
		return arr[min].prefix;
	}
	
}