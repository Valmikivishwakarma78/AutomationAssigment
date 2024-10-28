package testcases;

import java.util.Date;

public class T2 {

	public static void main(String[] args) {

		Date date = new Date();
		String name=date.toString().replace(" ", "_").replace(":", "_"); //Sun Oct 27 15:53:22 IST 2024
		System.out.println(name);
	}

}
