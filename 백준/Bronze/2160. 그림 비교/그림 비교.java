import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[][][] = new String[n][5][7];

        for(int z = 0; z < n; z++) {
            for(int i = 0; i < 5; i++) {
                String input[] = br.readLine().split("");
                for(int j = 0; j < 7; j++) {
                    arr[z][i][j] = input[j];
                }
            }
        }

        int ans_q = 0;
        int ans_w = 0;
        int ans_point = 999;
        for(int q = 0; q < n; q++) {
            for(int w = q + 1; w < n; w++) {
                int point = 0;
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 7; j++) {
                        if(!arr[q][i][j].equals(arr[w][i][j])) {
                            point++;
                        }
                    }
                }
                if(point < ans_point) {
                    ans_point = point;
                    ans_q = q + 1;
                    ans_w = w + 1;
                }
            }
        }

        System.out.println(ans_q + " " + ans_w);

    }
}
