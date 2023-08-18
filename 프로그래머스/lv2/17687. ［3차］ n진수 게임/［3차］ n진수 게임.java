class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String str = "";
        for(int i = 0; str.length() < t * m; i++ ) {
            str += Integer.toString(i , n);
        }
        
        int index = p - 1;
        for(int i = 0; i < t; i ++) {
            answer += str.substring(index , index + 1).toUpperCase();
            
            index += m;
        }
        
        return answer;
    }
}