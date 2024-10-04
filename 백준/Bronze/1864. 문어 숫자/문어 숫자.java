import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input[] = br.readLine().split("");
            if(input[0].equals("#")) {
                return;
            }

            int ans=0;
            int length = input.length;
            int i = length;
            for(String number : input) {
                i --;
                int a = 0;
                switch (number) {
                    case "-" :
                        a = 0;
                        break;
                    case "\\":
                        a = 1;
                        break;
                    case "(":
                        a = 2;
                        break;
                    case "@":
                        a = 3;
                        break;
                    case "?":
                        a = 4;
                        break;
                    case ">":
                        a = 5;
                        break;
                    case "&":
                        a = 6;
                        break;
                    case "%":
                        a = 7;
                        break;
                    case "/":
                        a = -1;
                        break;
                }
                a = a * (int) Math.pow(8 , i);
                ans += a;
            }

            System.out.println(ans);
        }
    }
}