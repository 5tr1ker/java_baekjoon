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
		for(int i = 0; i < N ; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str , new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
				// o1.compareTo(o2) o1이 단어 순서가 앞이면 True 
				// o1.length() - o2.length() 길이가 다를경우 긴 문자열이 앞에 오게 설정
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(str[0] + "\n");
		for(int i = 1; i < N ; i++) {
			if (str[i - 1].equals(str[i])) continue;
			sb.append(str[i]).append("\n");
		}
		System.out.println(sb);
	}
}
