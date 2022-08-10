import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String Str = br.readLine();
		int count = 0 , index = 0;
		
		for(int i = 0; i < M; i++) {
			if(Str.charAt(i) == 'I') {
				
				for(index = 0; index + i < M ; index+= 2) {
					if(index >= N * 2) {
						count++;
					}
					
					if(index + i + 1 < M && Str.charAt(index + i + 1) != 'O') {
						break;
					}
					
					if (index + i + 2 < M && Str.charAt(index + i + 2) != 'I') {
						break;
					}
					
				}
				
				i += index;
			}
		}
		
		System.out.println(count);
	}

}