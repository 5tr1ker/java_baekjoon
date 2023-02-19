import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int start , end;

	public Point(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TS = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(TS-- > 0) {
			st = new StringTokenizer(br.readLine() , " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			Point pnt[] = new Point[M];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				pnt[i] = new Point(start, end);
			}
			
			Arrays.sort(pnt , new Comparator<Point>() {
				@Override
				public int compare(Point o1 , Point o2) {
					if(o1.end == o2.end) return o1.start - o2.start;
					return o1.end - o2.end;
				}
			});
			
			boolean check[] = new boolean[N + 1];
			for(int i = 0; i < M; i++) {
				int x = pnt[i].start;
				int y = pnt[i].end;
				
				for(int j = x; j <= y; j++) {
					if(!check[j]) {
						ans++;
						check[j] = true;
						break;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}