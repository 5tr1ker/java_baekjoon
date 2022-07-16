import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine() , " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine() , " ");
		Long gas[] = new Long[N];
		Long dis[] = new Long[N];
		Long result = 0L;
		for(int i = 0; i < N - 1; i++) {
			dis[i] = Long.parseLong(st1.nextToken());
			gas[i] = Long.parseLong(st2.nextToken());
		}

		Long Min = gas[0];
		for(int i = 0; i < N - 1; i++) {
			if(Min > gas[i]) {
				Min = gas[i];
			}
			result += dis[i] * Min;
		}
		
		System.out.println(result);
	}
}