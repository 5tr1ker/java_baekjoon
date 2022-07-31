import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[] = new String[N];
		int arr[][] = new int[26][2];
		int i;
		long total = 0;
		
		for(i = 0; i < N; i++) {
			str[i] = br.readLine();
			for(int j = 0; j < str[i].length() ; j++) {
				arr[(int)str[i].charAt(j) - 65][0] += (int) Math.pow(10 , str[i].length() - j);
				arr[(int)str[i].charAt(j) - 65][1] = (int)str[i].charAt(j);
			}
		}
		
		Arrays.sort(arr , Comparator.comparing((int [] o1) -> o1[0]).reversed());

		for(int j = 0; j < str.length ; j++) {
			for(i = 0; i < 10 ; i++) {
				str[j] = str[j].replace(String.valueOf((char)arr[i][1]) , Integer.toString(9 - i));
			}
		}
		
		for(i = 0; i < str.length; i++) {
			total += Integer.parseInt(str[i]);		
		}
		
		System.out.println(total);
	}
}