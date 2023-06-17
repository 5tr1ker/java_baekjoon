import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int z = 0; z < 3; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int input = Integer.parseInt(st.nextToken());

                if(input == 0) {
                    cnt ++;
                }
            }

            switch (cnt) {
                case 4 :
                    System.out.println("D"); // 윺ㅊ
                    break;
                case 3:
                    System.out.println("C"); // 걸
                    break;
                case 2:
                    System.out.println("B"); // 개
                    break;
                case 1:
                    System.out.println("A"); // 도
                    break;
                case 0:
                    System.out.println("E"); // 모
                    break;
            }
        }

    }
}