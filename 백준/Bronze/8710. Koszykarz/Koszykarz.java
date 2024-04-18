import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        b -= a;

        if (b <= 0) {
            System.out.print(0);
        } else {
            int d = b / c;
            if (b % c != 0) d += 1;
            System.out.print(d);
        }
    }
}
