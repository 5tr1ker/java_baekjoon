import java.io.*;
import java.lang.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static int [][]arr;
    static int V , E;
    static int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new int[V + 1][V + 1];

        for(int i = 1; i <= V; i++)
            Arrays.fill(arr[i] , INF);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b] , c);
        }

        for(int z = 1; z <= V; z++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    if(i != j && arr[i][j] > arr[i][z] + arr[z][j]) {
                        arr[i][j] = arr[i][z] + arr[z][j];
                    }
                }
            }
        }

        int ans = 1_000_000_000;
        for(int i = 1; i <= V; i++) {
            for(int j = i + 1; j <= V; j++) {
                if(arr[i][j] + arr[j][i] < INF) {
                    ans = Math.min(arr[i][j] + arr[j][i] , ans);
                }
            }
        }

        System.out.println(ans == 1_000_000_000 ? -1 : ans);
    }
}