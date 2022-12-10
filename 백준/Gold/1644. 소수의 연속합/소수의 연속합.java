import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static boolean prime[];
	static ArrayList<Integer> decimal;
	static int total = 0;

	public static void getPrimeNumber(int n) {
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= n; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= n; j += i)
					prime[j] = true;
			}
		}

		for (int i = 0; i <= n; i++) {
			if (!prime[i])
				decimal.add(i);
		}
	}
	
	public static void twoPointer(int dest) {
		int start = 0;
		int end = 0;
		int sum = 0;
		while(true) {
			if(sum >= dest) sum -= decimal.get(end++);
			else if(start == decimal.size()) break;
			else sum += decimal.get(start++);
			if(sum == dest) total++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		prime = new boolean[N + 1];
		decimal = new ArrayList<Integer>();
		getPrimeNumber(N);
		twoPointer(N);
		System.out.println(total);
	}

}
