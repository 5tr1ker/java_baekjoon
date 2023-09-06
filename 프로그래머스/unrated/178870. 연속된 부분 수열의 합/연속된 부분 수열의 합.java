class Solution {
    public int[] solution(int[] sequence, int k) {
        if(sequence[0] == k) {
            return new int[] {0,0};
        }
        
        int start = 0;
        int end = 1;
        int sum = sequence[start] + sequence[end];
        int ansLength = 1_000_001;
        
        int length = 0;
        int[] answer = {start , end};
        
        while(end < sequence.length) {
            if(sum == k) {
                if(length < ansLength) {
                    ansLength = length;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            
            if(start >= sequence.length) {
                break;
            }
            
                if(sum > k || end + 1 >= sequence.length) {
                    sum -= sequence[start];
                    start++;
                    length--;
                } else {
                    end++;
                    sum += sequence[end];
                    length++;
                    
                }
        }
        
        
        return answer;
    }
}