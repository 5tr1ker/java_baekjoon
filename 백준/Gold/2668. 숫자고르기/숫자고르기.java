import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static int map[];
    static boolean check[];
    static int max = 0;
    static boolean ansIndex[];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        check = new boolean[N + 1];
        ansIndex = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            check = ansIndex.clone();

            if(map[i] == i) {
                ansIndex[i] = true;
                max++;

                continue;
            }

            if(!check[i]) {
                check[i] = true;

                dfs(i , i , 1);
            }
        }

        StringBuilder sb = new StringBuilder(max + "\n");
        for(int i = 1; i <= N; i++) {
            if(ansIndex[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int start , int dest , int count) {
        if(!ansIndex[map[start]] && dest == map[start]) {
            max += count;

            // Clone
            for(int i = 1; i < check.length; i++) {
                if(check[i]) {
                    ansIndex[i] = true;
                }
            }

            return;
        }

        if(!check[map[start]]) {
            check[map[start]] = true;
            dfs(map[start] , dest , count + 1);
        }
    }
}