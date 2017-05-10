package com.reacher.rpn;

public class Utils {
	
	public static class CalculatorUtil {
		
		public static boolean isNumber(char ch) {
			if('0' <= ch && '9' >= ch) {
				return true;
			}
			return false;
		}
		
		public static boolean isOperator(char ch) {
			if(ch == '+') {
				return true;
			}
			if(ch == '-') {
				return true;
			}
			if(ch == '*') {
				return true;
			}
			if(ch == '/') {
				return true;
			}
			if(ch == '%') {
				return true;
			}
			if(ch == '(') {
				return true;
			}
			return false;
		}
		
		public static int calculate(int data1, int data2, char op) {
			if('+' == op) {
				return data1 + data2;
			}
			if('-' == op) {
				return data1 - data2;
			}
			if('*' == op) {
				return data1 * data2;
			}
			return data1 / data2;
		}
	}
}
