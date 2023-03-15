package lec0306.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) throws FileNotFoundException {
		int[] nums = new int[15];

		{
			String fileName = "res/data.txt";
			FileInputStream fis = new FileInputStream(fileName);
			Scanner scan = new Scanner(fis);

			String line = scan.nextLine();

			String[] tokens = line.split(" ");

			for (int i = 0; i < tokens.length; i++) {
				nums[i] = Integer.parseInt(tokens[i]);
			}
			System.out.println("로드 완료.");
		}

		{
			Random random = new Random();
			for (int i = 0; i < 50; i++) {
				int ran1 = random.nextInt(15);
				int ran2 = random.nextInt(15);

				int temp;

				temp = nums[ran1];
				nums[ran1] = nums[ran2];
				nums[ran2] = temp;
			}
		}
		
		{
			String fileName = "res/data-out.txt";
			FileOutputStream fos = new FileOutputStream(fileName);
			PrintStream ps = new PrintStream(fos);
			
			for (int i = 0; i < nums.length; i++) {
				ps.printf("%d ",nums[i] );
			}
			System.out.println("저장 완료.");
		}
	}
}
