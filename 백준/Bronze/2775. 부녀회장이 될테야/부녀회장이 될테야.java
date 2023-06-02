import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TS = Integer.parseInt(br.readLine());

        while(TS-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int arr[] = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                arr[i] = i;
            }

            for(int j = 0; j < k; j++) {
                for(int i = 1; i <= n; i++) {
                    arr[i] = arr[i - 1] + arr[i];
                }
            }

            System.out.println(arr[n]);
        }
    }
}