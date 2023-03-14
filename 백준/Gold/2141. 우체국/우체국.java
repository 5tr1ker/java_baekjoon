import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Village {
	int idx;
	int people;
	
	public Village(int idx, int people) {
		this.idx = idx;
		this.people = people;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Village arr[] = new Village[N];
		StringTokenizer st;
		long totalPeople = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int idx = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			
			arr[i] = new Village(idx, people);
			totalPeople += people;
		}
		
		Arrays.sort(arr , new Comparator<Village>() {
			@Override
			public int compare(Village o1, Village o2) {
				return o1.idx - o2.idx;
			}
		});
		
		long sum = 0;
		for(int i = 0; i < N; i++) {
			Village village = arr[i];
			
			sum += village.people;
			if(sum >= totalPeople / 2.0) {
				System.out.println(village.idx);
				return;
			}
		}
		
	}
}