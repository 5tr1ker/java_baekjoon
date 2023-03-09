import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Room {
	int num;
	int attack;
	int hp;
	
	public Room(int num, int attack, int hp) {
		this.num = num;
		this.attack = attack;
		this.hp = hp;
	}
}

public class Main {
	
	static Room room[];
	static int N , offensePower;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		offensePower = Integer.parseInt(st.nextToken());
		
		room = new Room[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int attack = Integer.parseInt(st.nextToken());
			int hp = Integer.parseInt(st.nextToken());
			room[i] = new Room(num, attack, hp);
		}
		
		System.out.println(binarySearch());
		
	}
	
	public static long binarySearch() {
		long min = 1;
		long max = Long.MAX_VALUE;
		
		while(min < max) {
			long half = (min + max) / 2;
			
			if(!solved(half)) {
				min = half + 1;
			} else {
				max = half;
			}
			
		}
		
		return min;
	}
	
	public static boolean solved(long half) {
		long power = offensePower;
		long nowHp = half;
		
		for(int i = 0; i < N; i++) {
			if(room[i].num == 1) { // 몬스터
				double damage = Math.ceil((double)(room[i].hp - power) / power);
				nowHp -= damage * room[i].attack;
			} else { // 포션
				power += room[i].attack;
				nowHp = Math.min(nowHp + room[i].hp , half); // 최대 체력은 넘기지 않는다.
			}
			
			if(nowHp <= 0) {
				return false;
			}
			
		}
		
		return true;
	}
	
}