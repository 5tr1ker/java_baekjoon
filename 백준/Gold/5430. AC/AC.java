import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		Deque<String> queue = new LinkedList<String>();
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < test; t++) {
			String func = br.readLine();
			queue.clear();
			boolean direct = true; // true는 앞에서부터 false는 뒤에서 부터
			boolean flag = true;
			
			int data = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine() , "[ , ]");
			
			while(st.hasMoreTokens()) {
				queue.addLast(st.nextToken());
			}
			
			for(int i = 0; i < func.length(); i++) {
				char c = func.charAt(i);
				if(c == 'R') {
					direct = !direct; // 방향 전환
				}
				else if (c == 'D') {
					if(queue.isEmpty()) {
						sb.append("error\n");
						flag = false;
						break;
					}
					else if(direct) {
						queue.pollFirst();
					} else {
						queue.pollLast();
					}
				}
			}
			
			if(flag) {
				if(direct) sb.append(queue.toString().replace(" " , "") + "\n");
				else {
					sb.append("[");
					while(!queue.isEmpty()) {
						sb.append(queue.pollLast() + ",");
					}
					if(sb.charAt(sb.length() - 1) == ',')sb.deleteCharAt(sb.length() - 1);
					sb.append("]\n");
				}
			}
		}
		System.out.println(sb);
	}
}