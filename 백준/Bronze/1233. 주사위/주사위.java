import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int arr[] = new int[81];
        for(int i = 1; i <= S1; i++) {
            for(int j = 1; j <= S2; j++) {
                for(int k = 1; k <= S3; k++) {
                    arr[i + j + k]++;
                }
            }
        }

        int ans = 0;
        int data = 0;
        for(int i = 1; i < 80; i++) {
            if(arr[i] > data) {
                data = arr[i];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}