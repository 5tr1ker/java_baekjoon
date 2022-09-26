import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static public int N;
	static public List<Long> list;
	
	public static void bruthForce(long num , int idx) {
		if(idx>10) return;
		list.add(num);
		for(int i = 0; i < num % 10; i++) {
			bruthForce((num * 10) + i , idx + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		if(N <= 10) {
			System.out.println(N);
			return;
		}
		if(N > 1022) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			bruthForce(i , 1);
		}
		Collections.sort(list);
		System.out.println(list.get(N));
	}
}