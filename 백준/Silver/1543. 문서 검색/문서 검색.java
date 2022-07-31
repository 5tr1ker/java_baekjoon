import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0 , index = 0;
		String a1 = br.readLine();
		String a2 = br.readLine();
		
		while(true) {
			index = a1.indexOf(a2);
			if(index == -1) break;
			else {
				a1 = a1.substring(index);
				a1 = a1.replaceFirst(a2, "");
				count++;
			}
			
		}
		
		System.out.println(count);
	}

}