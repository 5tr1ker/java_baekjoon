import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int size = input.length() / N;

        String arr[][] = new String[size][N];
        int index = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < N; j++, index++) {
                if(i % 2 == 0) {
                    arr[i][j] = input.substring(index , index + 1);

                    continue;
                }

                arr[i][N - j - 1] = input.substring(index , index + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < size; j++) {
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb);


    }
}