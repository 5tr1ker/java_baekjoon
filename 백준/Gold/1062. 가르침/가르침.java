import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, K;
	public static boolean check[];
	public static String map[];
	public static int maxValue = 0;
	public static int q = 0;

	public static void bruthForce(int idx, int count) {
		if (count == K) {
			int total = 0;
			boolean Flag;

			for (int i = 0; i < map.length; i++) {
				String str = map[i]; 
				Flag = true; 
				for (int j = 0; j < str.length(); j++) {
					if (!check[str.charAt(j) - 'a']) {
						Flag = false;
						break;
					}
				}
				if (Flag) total++;
			}

			maxValue = Math.max(total, maxValue);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (check[i] == false) {
				check[i] = true;
				bruthForce(i, count + 1);
				check[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new boolean[26];
		map = new String[N];

		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
			map[i].replace("anta", "");
			map[i].replace("tica", "");
		}

		check['a' - 97] = check['c' - 97] = check['n' - 97] = check['t' - 97] = check['i' - 97] = true;

		bruthForce(0, 5);
		System.out.println(maxValue);
	}

}