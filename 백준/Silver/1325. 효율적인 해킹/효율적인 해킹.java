import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] arr;
	static boolean check[];
	static int results[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        results = new int[N + 1];
        
        for(int i = 0; i <= N; i++)
        	arr[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int idx1 = Integer.parseInt(st.nextToken());
        	int idx2 = Integer.parseInt(st.nextToken());
        	
        	arr[idx2].add(idx1);
        }
        
        
        for(int i = 1; i <= N; i++) {
        	check = new boolean[N + 1];
        	
        	Queue<Integer> queue = new LinkedList<Integer>();
        	queue.offer(i);
        	check[i] = true;
        	
        	while(!queue.isEmpty()) {
        		int data = queue.poll();
        		
        		for(int index : arr[data]) {
        			if(!check[index]) {
        				check[index] = true;
        				queue.offer(index);
        				results[i]++;
        			}
        		}
        	}
        	
        	max = Math.max(max, results[i]);
        }
        
        for(int i = 1; i <= N; i++) {
        	if(max == results[i]) sb.append(i).append(" ");
        }
        
        System.out.println(sb);
	}
}