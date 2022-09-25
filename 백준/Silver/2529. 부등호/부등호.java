import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static long min = Long.MAX_VALUE;
	public static long max = Long.MIN_VALUE;
	public static int N;
	public static boolean check[];
	public static String map[];
	public static int index[];

	public static void bruthForce(int count) {
		if (count == N) {
			long number = 0;
			
			for (int i = 0; i <= N; i++) {
				number += index[i] * Math.pow(10 , N - i);
			}
			min = Math.min(min, number);
			max = Math.max(max, number);
			return;
		}
		
		for (int j = 0; j < 10; j++) {
			if (map[count].equals("<")) { // <
				if (index[count] < j && !check[j]) {
					check[j] = true;
					index[count + 1] = j;
					bruthForce(count + 1);
					check[j] = false;
				}
			} else { // >
				if (index[count] > j && !check[j]) {
					check[j] = true;
					index[count + 1] = j;
					bruthForce(count + 1);
					check[j] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new String[N];
		check = new boolean[10];
		index = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int i = 0;
		while (st.hasMoreTokens()) {
			map[i] = st.nextToken();
			i++;
		}

		for (i = 0; i < 10; i++) {
			check[i] = true;
			index[0] = i;
			bruthForce(0);
			check[i] = false;
		}
		
		if(max < Math.pow(10 , N)) {
			System.out.println("0" + max);
		} else {
			System.out.println(max);
		}
		if(min < Math.pow(10 , N)) {
			System.out.println("0" + min);
		} else {
			System.out.println(min);
		}
	}

}
