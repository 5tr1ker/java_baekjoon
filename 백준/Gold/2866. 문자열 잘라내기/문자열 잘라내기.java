import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C;
	static char arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		System.out.println(binarySearch() - 1);
		
	}
	
	public static int binarySearch() {
		int min = 0;
		int max = C - 1;
		
		while(min < max) {
			int half = (min + max) / 2;
			
			if(checkString(half)) {
				min = half + 1;
			} else {
				max = half;
			}
		}
		
		return min;
	}
	
	public static boolean checkString(int half) {
		HashSet<String> hash = new HashSet<String>();
		for(int i = 0 ; i < C; i++) {
			String str = "";
			for(int j = half; j < R; j++) {
				str += arr[j][i];
			}
			
			if(hash.contains(str)) {
				return false;
			}
			
			hash.add(str);
		}
		
		return true;
	}
	
}