import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
	HashMap<String, Node> hash = new HashMap<String, Node>();
}

public class Main {
	
	static public StringBuilder sb;
	static public Node head;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		sb = new StringBuilder();
		
		head = new Node();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine() , " ");
			int K = Integer.parseInt(st.nextToken());
			
			Node now = head;
			for(int j = 0; j < K; j++) {
				String str = st.nextToken();
				
				if(!now.hash.containsKey(str)) { // 키가 없다?
					now.hash.put(str, new Node());
				}
				now = now.hash.get(str);
			}
		}
		
		print(head , "");
		System.out.println(sb);
		
	}
	
	public static void print(Node cur , String prefix) {
		Object keys[] = cur.hash.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object str : keys) {
			sb.append(prefix).append(str).append("\n");
			print(cur.hash.get(str) , prefix + "--");
		}
	}

}