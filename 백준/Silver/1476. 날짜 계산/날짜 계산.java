import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[3];
		int arr2[] = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = 1;
		}

		int index = 1;

		while (true) {

			if (arr[0] == arr2[0] && arr[1] == arr2[1] && arr[2] == arr2[2])
				break;

			index++;
			arr2[0]++;
			arr2[1]++;
			arr2[2]++;
			
			if(arr2[0] > 15) arr2[0] = 1;
			if(arr2[1] > 28) arr2[1] = 1;
			if(arr2[2] > 19) arr2[2] = 1;
		}

		System.out.println(index);
	}

}