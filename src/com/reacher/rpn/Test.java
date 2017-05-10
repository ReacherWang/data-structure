package com.reacher.rpn;

public class Test {

	
	public static void main(String[] args) throws Exception {
		//String data = "5*3-7+9/3+2";
		
		String data = "9 * 4 - (5 - 2) * 7 + 5";
		
		//String data = "(4 + 9) * 3 - 7 * (2 + 3)";
		
		int result = Calculator.calculate(data);
		
		System.out.println(result);
	}
	
}
