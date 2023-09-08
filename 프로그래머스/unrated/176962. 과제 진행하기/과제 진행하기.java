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
        
        for(int i = 0; i < plans.length; i++) {
            System.out.println(homework[i].name + " // " + homework[i].startTime + " // " + homework[i].time);
        }
        
        for(int i = 0; i < plans.length - 1; i++) {
            int current = homework[i].startTime + homework[i].time;
            int next = homework[i + 1].startTime;
            
            int term = next - current;
            System.out.println("term : " + term);
            if(term < 0) { // not
                homework[i].time = term * -1;
                System.out.println("불가능 : " + term*-1);
                stack.push(i);
            } else { // done!
                answer[ans++] = homework[i].name;
                int remain = term;
                System.out.println("done! And Remain : " + remain);
                while(remain > 0 && !stack.isEmpty()) {
                    int idx = stack.peek();
                    int diff = remain - homework[idx].time;
                    
                    System.out.println("do More? :  " + diff + " remain : " + remain);
                    if(diff >= 0) {
                        answer[ans++] = homework[idx].name;
                        homework[stack.pop()].time = diff;
                        remain = diff;
                        System.out.println("YES! " + diff + " remain : " + remain);
                    } else {
                        homework[stack.peek()].time -= remain;
                        remain = 0;
                    }
                }
            }
        }
        
        answer[ans++] = homework[homework.length - 1].name;
        
        while(!stack.isEmpty()) {
            int i = stack.peek();
            System.out.println(homework[i].name + " - " + homework[i].startTime + " - " + homework[i].time);
            answer[ans++] = homework[stack.pop()].name;
        }
        
        return answer;
    }
}