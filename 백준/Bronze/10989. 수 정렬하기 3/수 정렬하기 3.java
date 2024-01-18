import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[10001];
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            arr[input] ++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {

            for(int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}