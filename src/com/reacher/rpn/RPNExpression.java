package com.reacher.rpn;

import java.util.Stack;

public class RPNExpression {

	public static String reverse(String data) throws Exception {
		Stack<String> stack = new Stack<String>();
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < data.length(); ++i) {
			char ch = data.charAt(i);
			if(ch == ' ') {//过滤空格
				continue;
			}
			if(Utils.CalculatorUtil.isNumber(ch)) {//数字直接拼接
				buffer.append(ch);
				continue;
			}
			if(ch == ')') {//如果是有括号则出栈拼接
				while(!stack.peek().equals("(")) {//直到出现左括号停止
					buffer.append(stack.pop());
				}
				stack.pop();//将左括号出栈
				continue;
			}
			if(!Utils.CalculatorUtil.isOperator(ch)) {//判断是否为操作符，如果不是则抛出异常信息
				throw new Exception("Operator error!");
			}
			while(!isDirectPush(stack, String.valueOf(ch))) {//判断当前操作符能否直接
				buffer.append(stack.pop());
			}
			stack.push(String.valueOf(ch));
		}
		while(!stack.isEmpty()) {
			buffer.append(stack.pop());
		}
		return buffer.toString();
	}
	
	private static boolean isDirectPush(Stack<String> stack, String op) throws Exception {
		if(stack.isEmpty()) {
			return true;
		}
		if(op.equals("(")) {
			return true;
		}
		if(stack.peek().equals("(")) {
			return true;
		}
		if(compareOpPriority(op, stack.peek()) > 0) {
			return true;
		}
		return false;
	}
	
	private static int compareOpPriority(String op1, String op2) throws Exception {
		return getOpPriority(op1.charAt(0)) - getOpPriority(op2.charAt(0));
	}
	
	private static int getOpPriority(char op) throws Exception {
		if(op == '+' || op == '-') {
			return -1;
		}
		if(op == '*' || op == '/' || op == '%') {
			return 1;
		}
		throw new Exception("Operator error!");
	}
}
