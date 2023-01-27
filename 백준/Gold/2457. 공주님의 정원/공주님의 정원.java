import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Flower {
	int start;
	int end;
	
	public Flower(int start , int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Flower arr[] = new Flower[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			
			String startM = st.nextToken();
			String startD = st.nextToken();
			if(startD.length() == 1) {
				startD = "0" + startD;
			}
			
			String endM = st.nextToken();
			String endD = st.nextToken();
			if(endD.length() == 1) {
				endD = "0" + endD;
			}
			
			arr[i] = new Flower(Integer.parseInt(startM + startD) , Integer.parseInt(endM + endD));
		}
		
		Arrays.sort(arr , new Comparator<Flower>() {

			@Override
			public int compare(Flower o1, Flower o2) {
				if(o1.start == o2.start) return o1.end - o2.end;
				return o1.start - o2.start;
			}
		
		});
		
		int count = 0;
		int index = 0;
		int start = 301;
		int end = 1201;
		int max = 0;
		
		while(start < end) {
			boolean isFind = false;
			
			for(int i = index ; i < N; i++) {
				
				if(arr[i].start > start)
					break;
				
				if(max < arr[i].end) {
					max = arr[i].end;
					index = i + 1;
					isFind = true;
				}
				
			}
			
			if(isFind) {
				start = max;
				count++;
			} else {
				break;
			}
			
		}
		
		if(start < end) System.out.println(0);
		else System.out.println(count);
	}
}