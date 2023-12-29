import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split("");

        for(int i = 0; i < input.length - 1; i++) {
            int front = 1;
            for(int j = 0; j <= i; j++) {
                front *= Integer.parseInt(input[j]);
            }

            int back = 1;
            for(int j = i + 1; j < input.length; j++) {
                back *= Integer.parseInt(input[j]);
            }

            if(front == back) {
                System.out.println("YES");

                return;
            }
        }

        System.out.println("NO");
    }
}
