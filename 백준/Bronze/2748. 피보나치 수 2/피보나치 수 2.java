import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[91];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= 90; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[N]);
    }
}