import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input[] = br.readLine().split(",");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(input[i]));
        }

        for(int i = 0; i < K; i++) {
            ArrayList<Integer> newArr = new ArrayList<>();

            for(int j = 1; j < arr.size(); j++) {
                newArr.add(arr.get(j) - arr.get(j - 1));
            }

            arr = (ArrayList<Integer>) newArr.clone();
        }

        StringBuilder sb = new StringBuilder();
        for(int element : arr) {
            sb.append(element).append(",");
        }

        System.out.println(sb.delete(sb.length() - 1, sb.length()));
    }
}
