import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long[] cho = new long[2];
        cho[0] = scanner.nextLong();
        cho[1] = scanner.nextLong();

        if(cho[0] % 2 == 0 || cho[1] % 2 == 0) System.out.println(0);
        else {
        	// 배열을 정렬하면 0번째가 작은 수이다. 
            // 물론 Math.min() 메소드로 구할 수 있다. 
            Arrays.sort(cho);
            System.out.println(cho[0]);
        }

    }
}