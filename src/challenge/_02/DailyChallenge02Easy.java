package challenge._02;

import java.util.Scanner;

public class DailyChallenge02Easy {

	public static void main(String[] args) {
		//compound interest formula
		//A=Pe^(r * t)
		double a = 0; //
		double p = 0;
		double r = 0;
		double t = 0;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter the principle amount");
		p = Double.parseDouble(kb.nextLine());
		
		System.out.println("Enter the rate");
		r = Double.parseDouble(kb.nextLine());
		
		System.out.println("Enter the number of years");
		t = Double.parseDouble(kb.nextLine());
		
		kb.close();
		
		a = p*Math.exp((r*t));
		
		System.out.println(a);
	}
}
