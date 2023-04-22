import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String str = Integer.toString(A * B * C);

        int arr[] = new int[10];
        for(char ch : str.toCharArray()) {
            arr[ch - '0']++;
        }

        for(int ans : arr) {
            System.out.println(ans);
        }
    }
}