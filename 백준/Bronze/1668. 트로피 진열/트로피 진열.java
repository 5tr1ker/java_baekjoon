import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            arr[i] = input;
        }

        int ans1 = 0;
        int ans2 = 0;

        int back = 0;
        for(int i = 0; i < N; i++) {
            if(back < arr[i]) {
                back = arr[i];
                ans1 ++;
            }
        }

        back = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(back < arr[i]) {
                back = arr[i];
                ans2 ++;
            }
        }

        System.out.println(ans1 + "\n" + ans2);
    }
}
