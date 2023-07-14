import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static String str[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        str = new String[x];
        for(int i = 0; i < x; i++) {
            str[i] = br.readLine();
        }

int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= x - 8; i++) {
            for(int j = 0; j <= y - 8; j++) {
int result = solved(i , j);
ans = Math.min(ans , result);
            }
        }
        System.out.println(ans);

    }

    public static int solved(int x , int y) {
int cnt = 0;
String stst[] = {"BWBWBWBW" , "WBWBWBWB"};
for(int i = 0; i < 8; i++) {
    for(int j = 0; j < 8; j++) {
        if(str[x + i].charAt(y + j) != stst[(x + i) % 2].charAt(j)) {
            cnt ++;
        }
    }
}

return Math.min(cnt , 64 - cnt);
    }
}