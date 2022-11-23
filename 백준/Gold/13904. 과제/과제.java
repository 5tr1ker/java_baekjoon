import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int day;
		int idx;
		
		public Point(int day, int idx) {
			this.day = day;
			this.idx = idx;
		}
		
		public String toString() {
			return String.format("[만기 : %d , 점수 : %d]", day , idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] arr = new Point[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			arr[i] = new Point(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr , new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return Integer.compare(o2.idx , o1.idx);
			}
		});

		int score[] = new int[1001];
		for(int i = 0; i < N; i++) {
			for(int j = arr[i].day; j > 0; j--) {
				if(score[j] == 0) {
					score[j] = arr[i].idx;
					break;
				}
			}
		}
		
		int total = 0;
		for(int i = 0; i < 1001; i++) {
			total += score[i];
		}
		
		System.out.println(total);
	}

}