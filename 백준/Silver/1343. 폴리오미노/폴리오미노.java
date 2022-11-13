import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder sb;
	public static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'X') {
				idx++;
			}
			else { // . 일 경우
				if(idx % 2 != 0) {
					System.out.println(-1);
					return;
				}
				settingPoliomino();
				sb.append(".");
			}
		}
		settingPoliomino();
		
		if(idx == 0) System.out.println(sb);
		else System.out.println(-1);
	}
	
	public static void settingPoliomino() {
		while(idx - 4 >= 0) {
			idx -= 4;
			sb.append("AAAA");
		}
		while(idx - 2 >= 0) {
			idx -= 2;
			sb.append("BB");
		}
	}
	
}