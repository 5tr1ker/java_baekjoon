import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int top[] = new int[N / 2];
		int down[] = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			top[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(down);
		Arrays.sort(top);

		int min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 1; i <= H; i++) {
			int conflict = binarySearch(0, N / 2, i, down) + binarySearch(0, N / 2, H - i + 1, top);
			if (conflict < min) {
				min = conflict;
				count = 1;
			}
			if (conflict == min) {
				count++;
			}
		}

		System.out.printf("%d %d\n", min, count - 1);
	}

	public static int binarySearch(int bottom, int top, int height, int arr[]) {

		while (top > bottom) {
			int half = (top + bottom) / 2;
			
			if (arr[half] >= height) {
				top = half;
			} else {
				bottom = half + 1;
			}

		}
		return arr.length - top;
	}

}
