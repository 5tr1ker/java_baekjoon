import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		bruthForce(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean flag = false;

	public static void bruthForce(int idx) {
		if(idx >= 81) {
			flag = true;
			return;
		}
		
		int x = idx / 9;
		int y = idx % 9;
		
		if(arr[x][y] != 0) {
			bruthForce(idx + 1);
		} else {
			for(int i = 1; i <= 9; i++) {
				if(check(x , y , i)) {
					arr[x][y] = i;
					
					bruthForce(idx + 1);
					if(flag) return;
					arr[x][y] = 0;
				}
			}
		}
	}

	public static boolean check(int x, int y, int idx) {
		for (int i = 0; i < 9; i++) { // y축과 x축 검사
			if (arr[i][y] == idx || arr[x][i] == idx)
				return false;
		}

		int dx = x / 3 * 3;
		int dy = y / 3 * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i + dx][j + dy] == idx)
					return false;
			}
		}

		return true;
	}
}