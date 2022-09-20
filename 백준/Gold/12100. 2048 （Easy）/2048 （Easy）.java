import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public int arr[][];
	static public int cloneArr[][];
	static public int N;
	static public int max = 0;

	public static void bruthForce(int direct) { // 0 왼쪽 1오른쪽 2위 3아래

		if (direct == 0) { // 왼쪽일 때
			for (int i = 0; i < N; i++) {
				int index = 0;
				int data = arr[i][0];
				for (int j = 1; j < N; j++) {
					if (arr[i][j] != 0) {
						if (data == 0) {
							data = arr[i][j];
							arr[i][index] = arr[i][j];
							arr[i][j] = 0;
						} else if (arr[i][j] == data) { // 겹칠 수 있다.
							arr[i][index] *= 2;
							arr[i][j] = data = 0;
							index++;
						} else { // 값이 다른경우
							data = arr[i][j];
							index++;
							arr[i][index] = arr[i][j];
							if(index != j) arr[i][j] = 0;
						}
					}
				}
			}
		}
		if(direct == 1) { // 오른쪽
			for (int i = N - 1; i >= 0; i--) {
				int index = N - 1;
				int data = arr[i][N - 1];
				for (int j = N - 2; j >= 0; j--) {
					if (arr[i][j] != 0) {
						if (data == 0) {
							data = arr[i][j];
							arr[i][index] = arr[i][j];
							arr[i][j] = 0;
						} else if (arr[i][j] == data) { // 겹칠 수 있다.
							arr[i][index] *= 2;
							arr[i][j] = data = 0;
							index--;
						} else { // 값이 다른경우
							data = arr[i][j];
							index--;
							arr[i][index] = arr[i][j];
							if(index != j) arr[i][j] = 0;
						}
					}
				}
			}
		}
		if(direct == 2) { // 위로
			for (int j = 0; j < N; j++) {
				int index = 0;
				int data = arr[0][j];
				for (int i = 1; i < N; i++) {
					if (arr[i][j] != 0) {
						if (data == 0) {
							data = arr[i][j];
							arr[index][j] = arr[i][j];
							arr[i][j] = 0;
						} else if (arr[i][j] == data) { // 겹칠 수 있다.
							arr[index][j] *= 2;
							arr[i][j] = data = 0;
							index++;
						} else { // 값이 다른경우
							data = arr[i][j];
							index++;
							arr[index][j] = arr[i][j];
							if(index != i) arr[i][j] = 0;
						}
					}
				}
			}
		}
		if(direct == 3){ // 아래로
			for (int j = N - 1; j >= 0; j--) {
				int index = N - 1;
				int data = arr[N - 1][j];
				for (int i = N - 2; i >= 0; i--) {
					if (arr[i][j] != 0) {
						if (data == 0) {
							data = arr[i][j];
							arr[index][j] = arr[i][j];
							arr[i][j] = 0;
						} else if (arr[i][j] == data) { // 겹칠 수 있다.
							arr[index][j] *= 2;
							arr[i][j] = data = 0;
							index--;
						} else { // 값이 다른경우
							data = arr[i][j];
							index--;
							arr[index][j] = arr[i][j];
							if(index != i) arr[i][j] = 0;
						}
					}
				}
			}
		}
	}
	
	public static void findIndex(int count) {
		if (count == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, arr[i][j]);
				}
			}
			return;
		}
		int copy[][] = new int[N][N];
		for(int i = 0; i < N; i++)
            copy[i] = arr[i].clone();
		
		for(int i = 0; i<4; i++) {
			bruthForce(i);
			findIndex(count + 1);
			for(int a = 0; a < N; a++)
                arr[a] = copy[a].clone();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cloneArr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findIndex(0);
		System.out.println(max);
		
	}

}
