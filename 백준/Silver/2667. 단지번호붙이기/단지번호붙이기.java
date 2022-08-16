import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int [][] graph;
	static boolean [][] check;
	static int appartment = 0;
	
	public static int findWay(int i , int j , int N) {
		int count = 0;
		
		int coorX[] = { -1 , 1 , 0 , 0 };
		int coorY[] = { 0 , 0 , 1 , -1 };
		
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {i , j});
		check[i][j] = true;
		count++;

		while(!queue.isEmpty()) {
			int arr[] = queue.poll();
			int n = arr[0];
			int m = arr[1];
			for(int z = 0; z < 4; z++) {
				if(n + coorY[z] < 0 || n + coorY[z] >= N || m + coorX[z] < 0 || m + coorX[z] >= N) continue;
				
				if(graph[n + coorY[z]][m + coorX[z]] != 0 && !check[n + coorY[z]][m + coorX[z]]) {
					count++;
					check[n + coorY[z]][m + coorX[z]] = true;
					queue.add(new int[] {n + coorY[z] , m + coorX[z]});
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		check = new boolean[N][N];
		String str = null;
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 1 && !check[i][j]) {
					appartment++;
					list.add(findWay(i , j , N));
				}
			}
		}
		
		System.out.println(appartment);
		list.sort((o1, o2) -> o1 > o2? 1 : -1);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
