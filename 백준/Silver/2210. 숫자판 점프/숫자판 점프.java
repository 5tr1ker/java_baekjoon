import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static int map[][];
    static int result[] = new int[6];
    static int coorX[] = {0,0,-1,1};
    static int coorY[] = {-1,1,0,0};
    static HashSet<String> str = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                result[0] = map[i][j];
                dfs(1 , i , j);
            }
        }

        System.out.println(str.size());
    }

    public static void dfs(int cnt, int x, int y) {
        if(cnt >= 6) {
            String resultString = "";
            for(int i = 0; i < 6; i++) {
                resultString += String.valueOf(result[i]);
            }

            str.add(resultString);

            return;
        }

        for(int i = 0; i < 4; i++) {
            int dx = x + coorX[i];
            int dy = y + coorY[i];
            if(dx < 0 || dx > 4 || dy < 0 || dy > 4) {
                continue;
            }

            result[cnt] = map[dx][dy];
            dfs(cnt + 1, dx, dy);
        }
    }
}