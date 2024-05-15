import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[4];

        for(int i = 0; i < 4; i++) {
            int input = Integer.parseInt(st.nextToken());

            arr[i] = input;
        }

        Arrays.sort(arr);

        System.out.println(Math.abs((arr[3] + arr[0]) - (arr[1] + arr[2])));
    }

}