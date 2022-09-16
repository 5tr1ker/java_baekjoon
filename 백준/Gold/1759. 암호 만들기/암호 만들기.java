import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static String arr[];
	static StringBuilder sb;
	static int index , N;
	static boolean check[];
	
	public static void bruthForce(int inx , int count) {
		
		if(count == index) {
			int vowel = 0; // 모음
			int conson = 0; // 자음
			for(int i = 0; i < arr.length; i++) {
				if(check[i]) {
					if("aeiou".contains(arr[i])) vowel++;
					if("bcdfghjklmnpqrstvwxyz".contains(arr[i])) conson++;
				}
			}
			
			if(vowel < 1 || conson < 2) return;
			
			for(int i = 0; i < arr.length; i++) {
				if(check[i]) {
					sb.append(arr[i]);
				}
			}
			sb.append("\n");
			return;
		}
		
		for( ; inx < N; inx++) {
			check[inx] = true;
			bruthForce(inx + 1 , count + 1);
			check[inx] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		index = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine() , " ");
		for(int i = 0; i < N; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		bruthForce(0 , 0);
		System.out.println(sb);
	}

}
