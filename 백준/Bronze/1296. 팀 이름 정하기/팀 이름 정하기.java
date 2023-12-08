import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int map[] = new int[26];
        for(int i = 0; i < name.length(); i++) {
            map[name.charAt(i) - 'A'] += 1;
        }

        int N = Integer.parseInt(br.readLine());
        double ansResult = 0;
        String resultName = "a";

        for(int i = 0; i < N; i++) {
            String team = br.readLine();
            int index[] = map.clone();
            for(int j = 0; j < team.length(); j++) {
                index[team.charAt(j) - 'A'] += 1;
            }

            double result = (double)((index[11] + index[14]) * (index[11] + index[21]) * (index[11] + index[4]) * (index[14] + index[21]) * (index[14] + index[4]) * (index[21] + index[4])) % 100;

            if(result > ansResult) {
                ansResult = result;
                resultName = team;
            } else if(result == ansResult) {
                if(resultName.compareTo(team) > 0) {
                    resultName = team;
                };
            }

        }

        System.out.println(resultName);

    }

}