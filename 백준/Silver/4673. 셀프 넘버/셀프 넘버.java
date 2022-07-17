public class Main {

	public static int Calu(int number) {
		int sum = number;
	    
		while(number != 0){
			sum = sum + (number % 10); // 첫 째 자리수
			number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
		}
	    
		return sum % 10000;
	}
	
	public static void main(String[] args) {
		boolean data[] = new boolean[10001];
		int result;
		
		for(int i = 0; i < 10000; i++) {
			result = Calu(i);
			data[result] = true;
			
			if(!data[i]) {
				System.out.println(i);
			}
		}
	}
}