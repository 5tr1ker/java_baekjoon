import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static public int N, M;
	static public int map[][]; // 0-> 빈 1-> 집 2-> 치킨집 3-> 선택된 치킨
	static public int count = Integer.MAX_VALUE;
	static public ArrayList<int[]> chickenList;
	static public ArrayList<int[]> houseList;
	static public boolean check[];

	public static void selectChicken(int i , int index) {

		if (index == M) {
			calculateStreatCount();
			return;
		}
		
		for (int num = i ; num < chickenList.size() ; num++) {
			if (!check[num]) {
				check[num] = true;
				selectChicken(num + 1 , index + 1);
				check[num] = false;
			}
		}
	}

	public static void calculateStreatCount() {
		int temp = Integer.MAX_VALUE;
		int total = 0;
		for (int i = 0; i < houseList.size(); i++) { // 모든 집을 비교
			temp = Integer.MAX_VALUE;

			for (int j = 0; j < chickenList.size() ; j++) { // 치킨집
				if (check[j]) {
					temp = Math.min(temp, Math.abs(chickenList.get(j)[0] - houseList.get(i)[0])
							+ Math.abs(chickenList.get(j)[1] - houseList.get(i)[1]));
				}
			}
			total += temp;
		}
		count = Math.min(total, count);
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chickenList = new ArrayList<int[]>();
		houseList = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					houseList.add(new int[] {i,j});
				} else if (map[i][j] == 2) {
					chickenList.add(new int[] {i,j});
				}
			}
		}
		check = new boolean[chickenList.size()];
		selectChicken(0 , 0);

		System.out.println(count);
	}

}