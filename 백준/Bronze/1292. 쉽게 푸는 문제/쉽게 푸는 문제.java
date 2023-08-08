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

        int arr[] = new int[1001];
        int index = 1;
        int num = 1;

        while(index < 1001) {
            for(int i = 0; i < num; i++) {
                if(i + index > 1000) {
                    break;
                }

                arr[i + index] = num;
            }

            index += num;
            num++;
        }

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = start; i <= end; i++) {
            ans += arr[i];
        }

        System.out.println(ans);
    }
}