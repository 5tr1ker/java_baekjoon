import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static int A , B , C;
    static boolean check[][][] , ans[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        check = new boolean[A + 1][B + 1][C + 1];
        ans = new boolean[C + 1];

        dfs(0 , 0 , C);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= C; i++) {
            if(ans[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int nowA , int nowB , int nowC) {
        if(check[nowA][nowB][nowC])
            return;

        check[nowA][nowB][nowC] = true;
        if(nowA == 0) {
            ans[nowC] = true;
        }

        // C -> A
        if(A >= nowC + nowA) {
            dfs(nowC + nowA , nowB , 0);
        } else {
            dfs(A , nowB , nowA + nowC - A);
        }

        // C -> B
        if(B >= nowC + nowB) {
            dfs(nowA , nowC + nowB , 0);
        } else {
            dfs(nowA , B , nowB + nowC - B);
        }

        // B -> A
        if(A >= nowA + nowB) {
            dfs(nowA + nowB , 0 , nowC);
        } else {
            dfs(A , nowA + nowB - A , nowC);
        }

        // B -> C
        if(C >= nowC + nowB) {
            dfs(nowA , 0 , nowB + nowC);
        } else {
            dfs(nowA , nowC + nowB - C , C);
        }

        // A -> B
        if(B >= nowA + nowB) {
            dfs(0 , nowA + nowB , nowC);
        } else {
            dfs(nowA + nowB - B , B , nowC);
        }

        // A -> C
        if(C >= nowA + nowC) {
            dfs(0 , nowB , nowA + nowC);
        } else {
            dfs(nowA + nowC - C , nowB , C);
        }

    }
}