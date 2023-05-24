import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split("");
        HashMap<String , Integer> hashMap = new HashMap<>();

        int max = -1;
        String ans = "";

        for(int i = 0; i < input.length; i++) {
            String str = input[i].toUpperCase();
            if(hashMap.containsKey(str)) {
                int num = hashMap.get(str) + 1;
                hashMap.put(str , num);
                if(max < num) {
                    max = num;
                    ans = str;
                }
            } else {
                hashMap.put(str , 1);
                if(max < 1) {
                    max = 1;
                    ans = str;
                }
            }
        }


        for(String keys : hashMap.keySet()) {
            if(hashMap.get(keys) == max && !keys.equals(ans)) {
                System.out.println("?");
                return;
            }
        }
        System.out.println(ans);
    }
}