import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Basket {
	int start;
	int end;
	
	public Basket(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		Basket bs = new Basket(1, M);
		int total = 0;
		
		for(int i = 0; i < J; i++) {
			int apple = Integer.parseInt(br.readLine());
			
			if(bs.start <= apple && bs.end >= apple) {
				continue;
			}
			
			if(bs.start > apple) { // 바구니 오른쪽에 있다면?
				while(bs.start > apple && bs.start >= 0) { // 왼쪽으로 이동
					bs.start--;
					bs.end--;
					total++;
				}
			} else { // 바구니가 왼쪽에 있다면?
				while(bs.end < apple && bs.end <= N) { // 오른쪽으로 이동
					bs.start++;
					bs.end++;
					total++;
				}
			}
		}
		
		System.out.println(total);
	}
	
	
}