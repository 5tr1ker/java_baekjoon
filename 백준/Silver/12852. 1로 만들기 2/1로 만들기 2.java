import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point {
	int number;
	String index;
	
	public Point(int number , String index) {
		this.number = number;
		this.index = index;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point[] arr = new Point[N + 1];
		arr[1] = new Point(0, "1");
		
		for(int i = 2; i <= N; i++) {
			int cnt = Integer.MAX_VALUE;
			int before = 0;
			
			if(i % 3 == 0) {
				cnt = arr[i / 3].number;
				before = i / 3;
			}
			
			if(i % 2 == 0) {
				if(cnt > arr[i / 2].number) {
					cnt = arr[i / 2].number;
					before = i / 2;
				}
			}
			
			if(cnt > arr[i - 1].number) {
				before = i - 1;
			}
			
			arr[i] = new Point(arr[before].number + 1 , i + " " + arr[before].index);
		}
		
		System.out.println(arr[N].number + "\n" + arr[N].index);
		
	}
}