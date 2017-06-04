package com.reacher.rpn;

import java.util.Stack;

public class Calculator {

	public static int calculate(String expression) throws Exception {
		String reverse = RPNExpression.reverse(expression);

		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < reverse.length(); ++i) {
			char ch = reverse.charAt(i);
			if(Utils.CalculatorUtil.isNumber(ch)) {
				stack.push(Integer.valueOf(String.valueOf(ch)));
				continue;
			}
			int operand = stack.pop();
			int beOperand = stack.pop();
			stack.push(Utils.CalculatorUtil.calculate(beOperand, operand, ch));
		}
		return stack.pop();
	}
	
}
