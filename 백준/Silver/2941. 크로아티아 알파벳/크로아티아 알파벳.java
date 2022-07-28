import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// c= , c- , dz= , d- , lj , nj , s= , z=
		String str = br.readLine();
		int count = 0;
		
		try {
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'c') {
					if(str.charAt(i + 1 ) == '=') {
						i++;
					}
					else if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
				
				if(str.charAt(i) == 'd') {
					if(str.length() > i + 2) {
						if(str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
							i+=2;
						}
					}
					if(str.charAt(i + 1) == '-') {
						i++;
					}
				}
				
				if(str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
					i++;
				}
				
				if(str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
					i++;
				}
				
				if((str.charAt(i) == 's' || str.charAt(i) == 'z') && str.charAt(i + 1) == '=') {
					i++;
				}
				count++;
			}
		} catch(StringIndexOutOfBoundsException e) {
			count++;
		}
		System.out.println(count);
	}
}