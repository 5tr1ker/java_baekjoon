import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][5];
        boolean check[][] = new boolean[N][N];

        for(int i = 0; i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int score[] = new int[N + 1];

        for(int z = 0; z < 5; z++) { // 학생
            for(int i = 0; i < N; i++) { // 기준
                for(int j = 0; j < N; j++) { // 비교
                    if(!check[i][j] && i != j && map[i][z] == map[j][z]) {
                        score[i + 1] += 1;
                        check[i][j] = true;
                    }
                }
            }
        }

        int max = 0;
        int ans = 1;
        for(int i = 1; i <= N; i++) {
            if(max < score[i]) {
                max = score[i];
                ans = i;
            }
        }

        System.out.println(ans);

    }

}