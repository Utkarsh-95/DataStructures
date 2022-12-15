package com.c.stack;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
//		String exp = "82/";
		String exp = "138+*";
		int res = evaluateExp(exp);
		System.out.println(res);
	}

	private static int evaluateExp(String exp) {

		Stack<Integer> stack = new Stack<>();

		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(c - '0');
				System.out.println(stack);
			} else {
				int x = stack.pop();// 8, 11
				int y = stack.pop();// 3, 1

				if (c == '+') {
					stack.push(y + x);
					System.out.println(stack);
				} else if (c == '-') {
					stack.push(y - x);
				} else if (c == '/') {
					stack.push(y / x);
				} else if (c == '*') {
					stack.push(y * x);
				}
			}
		}

		return stack.pop();
	}

}
