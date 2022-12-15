package com.c.stack;

import java.util.Stack;

public class BalancedBracketsWithStackOnly {

	public static void main(String[] args) {
		String input = "(){[]}{}";
		System.out.println(checkBalancedBrackets(input));
	}

	private static boolean checkBalancedBrackets(String input) {

		if (input.isEmpty()) {
			return false;
		}

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {

			if (st.isEmpty()) {
				st.push(input.charAt(i));
			} else if (st.peek() == '(' && input.charAt(i) == ')' 
					|| st.peek() == '{' && input.charAt(i) == '}'
					|| st.peek() == '[' && input.charAt(i) == ']') {
				st.pop();
			} else {
				st.push(input.charAt(i));
			}

		}

		if (st.isEmpty()) {
			return true;
		}
		return st.isEmpty();
	}

}
