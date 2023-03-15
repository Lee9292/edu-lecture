package ex8.oop.capsule.lotto;

import java.util.Random;

public class LottoProgram {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// lotto라는 이름의 정수 6개를 담을 수 있는 배열을 생성
		int[] lotto = new int[6];

		// 랜덤 값을 lotto배열에 담는 코드를 작성
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			lotto[i] = rand.nextInt(45) + 1;

		for (int i = 0; i < 100; i++)
			System.out.println();

		// lotto 배열의 값을 모두 출력한다.
		// 초기 랜덤 값
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

		Thread.sleep(2000);

		// 복권의 0번째 값과 1번째 값의 위치를 변경
		{
			int temp = lotto[0];
			lotto[0] = lotto[1];
			lotto[1] = temp;

		}

		for (int i = 0; i < 100; i++)
			System.out.println();
		// lotto 배열의 값을 모두 출력한다.
		// 정렬 된 배열의 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

		Thread.sleep(2000);

		// 복권의 0번째 값과 1번째 값의 위치를 변경
		{
			int temp = lotto[1];
			lotto[1] = lotto[2];
			lotto[2] = temp;

		}

		for (int i = 0; i < 100; i++)
			System.out.println();
		// lotto 배열의 값을 모두 출력한다.
		// 정렬 된 배열의 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

		Thread.sleep(2000);

		// 복권의 0번째 값과 1번째 값의 위치를 변경
		{
			int temp = lotto[2];
			lotto[2] = lotto[3];
			lotto[3] = temp;

		}

		for (int i = 0; i < 100; i++)
			System.out.println();

		// lotto 배열의 값을 모두 출력한다.
		// 정렬 된 배열의 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

		Thread.sleep(2000);

		// 복권의 0번째 값과 1번째 값의 위치를 변경
		{
			int temp = lotto[3];
			lotto[3] = lotto[4];
			lotto[4] = temp;

		}

		for (int i = 0; i < 100; i++)
			System.out.println();
		// lotto 배열의 값을 모두 출력한다.
		// 정렬 된 배열의 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

		Thread.sleep(2000);

		// 복권의 0번째 값과 1번째 값의 위치를 변경
		{
			int temp = lotto[4];
			lotto[4] = lotto[5];
			lotto[5] = temp;

		}

		for (int i = 0; i < 100; i++)
			System.out.println();
		// lotto 배열의 값을 모두 출력한다.
		// 정렬 된 배열의 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d", lotto[i]);

			if (i != 5)
				System.out.print(",");
		}
		System.out.println();

	}

}
