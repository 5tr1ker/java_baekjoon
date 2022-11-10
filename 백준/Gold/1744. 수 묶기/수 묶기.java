import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> link1 = new LinkedList<Integer>();
		LinkedList<Integer> link2 = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			if(index > 0) {
				link1.add(index);
			} else {
				link2.add(index);
			}
		}
		
		Collections.sort(link1);
		Collections.sort(link2);
	
		int total = 0;
		
		for(int i = 0 ; i < link2.size() ; i += 2 ) {
			if(i + 1 >= link2.size()) {
				if(link2.size() == i + 1) {
					total += link2.get(i);
				}
				break;
			}
			int idx1 = link2.get(i);
			int idx2 = link2.get(i + 1); 
			total += Math.max(idx1 * idx2 , idx1 + idx2);
		}
		
		for(int i = link1.size() - 1 ; i > 0 ; i -= 2 ) {
			int idx1 = link1.get(i);
			int idx2 = link1.get(i - 1);
			total += Math.max(idx1 * idx2 , idx1 + idx2);
		}
		
		if(link1.size() % 2 != 0) total += link1.get(0);
		
		System.out.println(total);
	}

}
