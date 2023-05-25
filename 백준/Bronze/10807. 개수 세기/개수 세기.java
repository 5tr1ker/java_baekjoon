import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = Integer.parseInt(br.readLine());

        int arr[] = new int[201];
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[input + 100]++;
        }
        System.out.println(arr[ans + 100]);
    }
}