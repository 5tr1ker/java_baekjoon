import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class StarPoint {
	public int num;
	public double x;
	public double y;
	
	public StarPoint(int num, double x , double y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "StarPoint [num=" + num + ", x=" + x + ", y=" + y + "]";
	}
}

class Star {
	public int x;
	public int y;
	double weight;
	
	public Star(int x , int y , double weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Star [x=" + x + ", y=" + y + ", weight=" + weight + "]";
	}
}

public class Main {
	
	public static double getWeight(StarPoint star1 , StarPoint star2) {
		return Math.sqrt(Math.pow(star1.x - star2.x , 2) + Math.pow(star1.y - star2.y, 2));
	}
	
	public static int findParent(int idx) {
		if(parent[idx] == idx) return idx;
		
		return parent[idx] = findParent(parent[idx]);
	}
	
	public static void unionFind(int idx1 , int idx2) {
		int f1 = findParent(idx1);
		int f2 = findParent(idx2);
		
		if(f1 != f2) {
			parent[f1] = f2;
		}
	}
	
	public static int parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Star> list = new ArrayList<Star>();
		parent = new int[N + 1];
		StringTokenizer st;
		
		StarPoint[] starPoint = new StarPoint[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			starPoint[i] = new StarPoint(i, x, y);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				double weight = getWeight(starPoint[i] , starPoint[j]);
				list.add(new Star(starPoint[i].num , starPoint[j].num , weight));
			}
		}
		
		Collections.sort(list , new Comparator<Star>() {
			@Override
			public int compare(Star o1, Star o2) {
				return o1.weight - o2.weight > 0 ? 1 : -1;
			}
		});
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		double weight = 0;
		for(int i = 0; i < list.size(); i++) {
			Star input = list.get(i);
			
			int parentX = findParent(input.x);
			int parentY = findParent(input.y);
			if(parentX != parentY) {
				unionFind(parentY, parentX);
				weight += input.weight;
			}
		}
		
		System.out.printf("%.2f \n" , weight);
	}

}