import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            Long num =Long.parseLong(br.readLine());
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int max=0;
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for(Integer val : list){
            if(max<val){
                max=val;
            }
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(Long key : map.keySet()){
            if(max==map.get(key)){
            	queue.add(key);
            }
        }
        System.out.println(queue.poll());

    }


}