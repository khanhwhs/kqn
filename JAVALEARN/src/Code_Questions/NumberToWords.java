package Code_Questions;

import java.util.Scanner;

public class NumberToWords {
	public static void main( String a[]){
		
		Scanner input = new Scanner(System.in);
		int num;
		System.out.print("Enter a number: ");
		num = input.nextInt();
		if( num == 0 ) System.out.println("Zero");
		else if ( num >=1 && num <=19) System.out.println(convertOneD(num));
		else if ( num >=20 && num <=99) System.out.println(convertTwoD(num));
		else if ( num >=100 && num <=999) System.out.println(convertThreeD(num));
	}
	
	public static String convertOneD(int num){
		if (num == 0) return "Zero";
		String []digitStr = {"","one","two","three","four","five","six", "seven", "eight", "nine", "ten","eleven","twelve"};
		return digitStr[num];
	}
	public static String convertTwoD(int num){
		String []digitStr = {"","","twenty","thirty","forty","fifty","sizty","seventy", "eighty", "ninety"};
		int num1 = num/10;
		int num2 = num%10;
		if ( num2 == 0) return digitStr[num1];
		else return digitStr[num1] + " " + convertOneD(num2);
	}
	public static String convertThreeD(int num){
		String []digitStr = {"","one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred", "nine hundred"};
		int num1 = num/100;
		int num2 = num%100;
		if ( num2 == 0) return digitStr[num1];
		else return digitStr[num1] + " and" + convertTwoD (num2);
	}
	public static String convertFSD(int num){
		
	}
	}
}
