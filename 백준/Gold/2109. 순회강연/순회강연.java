import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int day;
		int score;
		
		public Point(int score , int day) {
			this.day = day;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Point [day=" + day + ", score=" + score + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point arr[] = new Point[N];
		boolean check[];
		StringTokenizer st;
		int maxValue = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int score = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			maxValue = Math.max(maxValue, day);
			arr[i] = new Point(score , day);
		}
		
		check = new boolean[maxValue + 1];
		Arrays.sort(arr , new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.score, o1.score);
			}
		});
		
		int total = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = arr[i].day ; j > 0; j--) {
				if(!check[j]) {
					check[j] = true;
					total += arr[i].score;
					break;
				}
			}
		}
		System.out.println(total);
	}

}