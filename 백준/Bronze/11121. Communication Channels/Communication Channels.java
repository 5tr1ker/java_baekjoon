import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // consume newline
        while (t-- > 0) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(isOk(a, b));
        }
        scanner.close();
    }

    private static String isOk(String a, String b) {
        if (a.length() != b.length()) {
            return "ERROR";
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return "ERROR";
            }
        }
        return "OK";
    }
}