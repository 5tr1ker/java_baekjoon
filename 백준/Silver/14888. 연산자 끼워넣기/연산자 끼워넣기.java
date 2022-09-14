
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int oper[];
	static int arr[];
	static int N;

	public static void bruthForce(int num, int count) {
		if (count == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) { // 연산자 추출

			if (oper[i] > 0) { // 연산자가 하나 이상이라도 있으면?
				oper[i]--;
				switch (i) {
				case 0: bruthForce(num + arr[count] , count + 1); break;
				case 1: bruthForce(num - arr[count] , count + 1); break;
				case 2: bruthForce(num * arr[count] , count + 1); break;
				case 3: bruthForce(num / arr[count] , count + 1); break;
				}
				oper[i]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		oper = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		bruthForce(arr[0], 1);

		System.out.println(max + "\n" + min);
	}

}
