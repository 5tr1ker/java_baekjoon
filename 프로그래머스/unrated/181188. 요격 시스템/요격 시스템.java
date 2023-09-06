import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets , new Comparator<int[]>() {
            
            @Override
            public int compare(int[] a , int[] b) {
                return a[1] - b[1];
            }
        });
            
        int answer = 0;
        int min = -1;
        for(int i = 0; i < targets.length ; i++) {
            if(min <= targets[i][0]) {
                min = targets[i][1];
                answer ++;
            }
        }
            
        return answer;
    }
}