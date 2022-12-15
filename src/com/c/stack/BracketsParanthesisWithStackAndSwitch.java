package com.c.stack;

import java.util.Stack;

public class BracketsParanthesisWithStackAndSwitch {

	private static boolean checkBalance(String input) {
		// === for data and data type and == only check datatype diff in js jquery

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '[' || input.charAt(i) == '(' || input.charAt(i) == '{') {
				st.push(input.charAt(i));
			} else {
				switch (input.charAt(i)) {
				case ']':
					if (st.peek() == '[') {
						st.pop();
					} else {
						return false;
					}
					break;
				case ')':
					if (st.peek() == '(') {
						st.pop();
					} else {
						return false;
					}
					break;
				case '}':
					if (st.peek() == '{') {
						st.pop();
					} else {
						return false;
					}
					break;
				}
			}
		}

		return st.isEmpty();
	}

	public static void main(String[] args) {
		String str = "{[()]}[{()}]";

		if (checkBalance(str) == true) {
			System.out.println("Balanced Paranthesis");
		} else {
			System.out.println("Not a Balanced Paranthesis");
		}
	}

}
