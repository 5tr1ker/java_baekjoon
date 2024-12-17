import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 동일한 숫자가 2개 있을 경우
        if (a == b || b == c || a == c) {
            System.out.println("S");
        } 
        // 두 수의 합이 하나의 수와 같은 경우
        else if (a + b == c || a + c == b || b + c == a) {
            System.out.println("S");
        } 
        // 그 외에는 못 돌아옴
        else {
            System.out.println("N");
        }

        scanner.close();
    }
}