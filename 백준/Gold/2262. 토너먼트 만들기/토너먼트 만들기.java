import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static public LinkedList<Integer> arr;
	static public int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		ans = 0;
		while (arr.size() > 1) {
			int index = find();
			
			if(index + 1 >= arr.size()) { // 가장 오른쪽에 있는 수
				ans += Math.abs(arr.get(index) - arr.get(index - 1));
			} else if (index - 1 < 0) { // 가장 왼쪽에 있는 수
				ans += Math.abs(arr.get(index) - arr.get(index + 1));
			} else {
				ans += Math.min(Math.abs(arr.get(index) - arr.get(index - 1)), Math.abs(arr.get(index) - arr.get(index + 1)));
			}
			arr.remove(index);
		}

		System.out.println(ans);

	}

	public static int find() {
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < arr.size(); i++) {
			if(max < arr.get(i)) {
				max = arr.get(i);
				index = i;
			}
		}
		
		return index;
	}

}