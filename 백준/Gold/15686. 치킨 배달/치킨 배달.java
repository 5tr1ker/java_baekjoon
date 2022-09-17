import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static public int N, M;
	static public int map[][]; // 0-> 빈 1-> 집 2-> 치킨집 3-> 선택된 치킨
	static public int count = Integer.MAX_VALUE;
	static public ArrayList<String> chickenList;
	static public ArrayList<String> houseList;
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
			String[] houseData = houseList.get(i).split(",");

			for (int j = 0; j < chickenList.size() ; j++) { // 치킨집
				if (check[j]) {
					String[] chickenData = chickenList.get(j).split(",");
					temp = Math.min(temp, Math.abs(Integer.parseInt(chickenData[0]) - Integer.parseInt(houseData[0]))
							+ Math.abs(Integer.parseInt(chickenData[1]) - Integer.parseInt(houseData[1])));
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
		chickenList = new ArrayList<String>();
		houseList = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					houseList.add(i + "," + j);
				} else if (map[i][j] == 2) {
					chickenList.add(i + "," + j);
				}
			}
		}
		check = new boolean[chickenList.size()];
		selectChicken(0 , 0);

		System.out.println(count);
	}

}