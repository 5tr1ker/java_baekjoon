import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int T = 1;
        int sumDiagonal = 0; // 사선 값
        // 1 2 3 4 5
        // 1 3 6 10 15
        while(true) {
            sumDiagonal += T;
            if(sumDiagonal >= X && sumDiagonal - T < X) {
                if(T % 2 != 0) { // 짝수 위에서 -> 밑
                    int ans1 = T;
                    int ans2 = 1;
                    for(int i = sumDiagonal - T + 1 ; i != X ;i++) {
                        ans1--; ans2++;
                    }
                    System.out.println(ans1 + "/" + ans2);
                } else { // 홀수 밑에서 -> 위
                    int ans1 = 1;
                    int ans2 = T;
                    for(int i = sumDiagonal - T + 1 ; i != X ;i++) {
                        ans1++; ans2--;
                    }
                    System.out.println(ans1 + "/" + ans2);
                }
                break;
            }
            T++;
        }
    }
}