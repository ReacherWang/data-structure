package com.reacher.rpn;

public class Test {

	/**
	 * A MOD B  ===>  A B MOD
	 *
	 * 9 + (3 - 1) * 3 + 10 / 2
	 *
	 * 第一步：9 + (3 1 -) * 3 + (10 2 /)
	 * 第二步：９ + (3 1 - 3 *) + (10 2 /)
	 * 第三步：(9 3 1 - 3 * +) + (10 2 /)
	 * 第四步：9 3 1 - 3 * + 10 2 / +
	 *
	 * 9 4 * 5 2 - 7 * - 5 +
	**/

	
	public static void main(String[] args) throws Exception {
		//String data = "5*3-7+9/3+2";
		
		String expression = "9 * 4 - (5 - 2) * 7 + 5";
		
		int result = Calculator.calculate(expression);
		
		System.out.println(expression + " = " + result);
	}
	
}
