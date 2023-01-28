import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	int start;
	int end;
	int weight;
	
	public Point(int start , int end , int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Point [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}
	
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		Point []input = new Point[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			input[i] = new Point(start, end, weight);
		}
		
		Arrays.sort(input , new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.end == o2.end) return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});
		
		int arr[] = new int[N + 1];
		int max = 0;
		int nowWeight = 0;
		int index = 1;
		
		for(int i = 0 ; i < M ; index++) {
			nowWeight -= arr[index];
			
			for( ; i < M && input[i].start <= index; i++) {
				
				if(C >= input[i].weight + nowWeight) { // 트럭에 충분히 채움
					nowWeight += input[i].weight;
					arr[input[i].end] += input[i].weight;
					max += input[i].weight;
				} else {	// 한계닷
					int diff = C - nowWeight; // 넣을 수 있는 공간
					nowWeight += diff;
					arr[input[i].end] += diff;
					max += diff;
				}
			}
			
		}
		
		System.out.println(max);
		
	}
}