import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N ; i++) {
			int idx = Integer.parseInt(st.nextToken());
			
			if(idx > 0) {
				list1.add(idx);
			} else {
				list0.add(Math.abs(idx));
			}
		}
		
		Collections.sort(list0 , Collections.reverseOrder());
		Collections.sort(list1 , Collections.reverseOrder());
		list0.add(0);
		list1.add(0);
		
		int count = 0 , i;
		if(list0.get(0) > list1.get(0)) {
			count += list0.get(0);
			for(i = M ; i < list0.size(); i += M) {
				count += list0.get(i) * 2;
			}
			for(i = 0 ; i < list1.size(); i += M) {
				count += list1.get(i) * 2;
			}
		} else {
			count += list1.get(0);
			for(i = M ; i < list1.size(); i += M) {
				count += list1.get(i) * 2;
			}
			for(i = 0 ; i < list0.size(); i += M) {
				count += list0.get(i) * 2;
			}
		}
		
		System.out.println(count);
	}

}