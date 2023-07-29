import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans[] = new int[3];
int T = Integer.parseInt(br.readLine());

if(T / 300 != 0) {
ans[0] = T / 300;
T %= 300;
}
if ( T / 60 != 0) {
    ans [1] = T / 60;
    T %= 60;
}
if ( T / 10 != 0) {
    ans [2] = T / 10;
    T %= 10;
}

if(T != 0) {
    System.out.println(-1);
    return;
}

        for(int i = 0; i < 3; i++) {
            System.out.printf("%d " , ans[i]);
        }
    }
}