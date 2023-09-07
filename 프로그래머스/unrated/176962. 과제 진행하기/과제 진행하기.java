import java.util.*;

class Homework {
    int startTime;
    String name;
    int time;
    
    public Homework(String name , String startTime , String time) {
        String[] tmp = startTime.split(":");
        this.name = name;
        this.startTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        this.time = Integer.parseInt(time);
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        Stack<Integer> stack = new Stack<>();
        Homework homework[] = new Homework[plans.length];
        String answer[] = new String[plans.length];
        int ans = 0;
        
        for(int i = 0; i < plans.length; i++) {
            homework[i] = new Homework(plans[i][0] , plans[i][1] , plans[i][2]);
        }
        
        Arrays.sort(homework , new Comparator<Homework>() {
            
            @Override
            public int compare(Homework h1 , Homework h2) {
                return h1.startTime - h2.startTime;
            }
        });
        
        for(int i = 0; i < homework.length - 1; i++) {
            int currentTime = homework[i].startTime + homework[i].time;
            int next = homework[i + 1].startTime;
            
            if(currentTime <= next) { // done
                answer[ans++] = homework[i].name;

                int remain = next - currentTime;
                while(remain > 0 && !stack.isEmpty()) {
                    int diff = homework[stack.peek()].time - remain;
                    homework[stack.peek()].time = Math.max(0 , diff);
                    System.out.println("major " + homework[stack.peek()].name + " time " + diff);
                    if(diff <= 0) {
                        remain = diff * -1;
                        System.out.println("done : " + remain);
                        answer[ans++] = homework[stack.pop()].name;
                    } else {
                        remain = 0;
                        System.out.println("no Remain : " +  homework[stack.peek()].time);
                    }
                }
            } else { // nt Yet
                stack.push(i);
                homework[i].time = currentTime - next;
                System.out.println("nope : " + homework[i].time + " major : " + homework[i].name);
            }
        }
        
        answer[ans++] = homework[homework.length - 1].name;
        
        while(!stack.isEmpty()) {
            answer[ans++] = homework[stack.pop()].name;
        }
        
        return answer;
    }
}