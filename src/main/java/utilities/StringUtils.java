package utilities;

import java.util.Random;

public class StringUtils {

	public static int getRandomNumber() {
		Random rand = new Random();
		return (int) rand.nextInt(10000);
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomNumber());
	}

}
