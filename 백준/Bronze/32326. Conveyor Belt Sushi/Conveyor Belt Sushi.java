import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[] {3,4,5};
        int ans = 0;
        for(int i = 0; i < 3; i++) {
            int next = Integer.parseInt(br.readLine());
            ans += arr[i] * next;
        }
        System.out.println(ans);
    }
}
