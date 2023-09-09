import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answerStack = new Stack<>();
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            int next = numbers[i];
            
            while(!stack.isEmpty() && stack.peek() <= next) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                answerStack.push(-1);
            } else {
                answerStack.push(stack.peek());
            }
            stack.push(next);
        }
        
        int[] answer = new int[answerStack.size()];
        int idx = 0;
        while(!answerStack.isEmpty()) {
            answer[idx++] = answerStack.pop();
        }
        
        
        return answer;
    }
}