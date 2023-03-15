package lec0313;

import java.util.Random;

public class DiceExample {

	public static void main(String[] args) {
		Random random = new Random();
		int[] results = new int[6];
		for(int i = 0; i<1000000; i++) {
			int dice = random.nextInt(6)+1;
//			System.out.printf("%d번째 주사위 숫자는 %d입니다.\n", i+1, dice);
			for (int j = 0; j < results.length; j++) {
				if(dice == j+1) {
					results[j]++;
				}
			}
		}
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]/10000f);
		}
	}

}
