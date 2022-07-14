import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int greed[][] = new int[testcase][2];
		
		for(int i = 0; i < testcase; i++) {
			st = new StringTokenizer(br.readLine());
			greed[i][0] = Integer.parseInt(st.nextToken());
			greed[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(greed , new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
			}
		});
		
		int count = 0;
		int standard = 0;
		for(int i = 0; i < testcase; i++) {
			
			if(standard <= greed[i][0]) {
				standard = greed[i][1];
				count++;
			}
			
		}
		
		System.out.println(count);
	}

}
