package com.smulders;
import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		BalancedBrackets bb = new BalancedBrackets();
		String[] testStrings = {
				"", 
				"(o87rt3qfgw a9e80;ucopjlf[)[])", 
				"()[]{}<>", 
				"({[<>]})",
				"({[<>])}",
				"if (i == 5) { doTask(); }",
				"<tbody>\n" +
				"  <tr *ngFor=\"let studcl of studentClassList; let i = index;\">\n" +
				"    <td class=\"td-input-text\">\n" + 
				"      <input class=\"control-input input-text\" type=\"text\" value=\"{{ studcl.name }}\" (change)=\"updateClassName($event,i)\">\n" + 
				"    </td>\n" +
				"  </tr>\n" +
				"</tbody>"
				};
		
		for (int i = 0; i < testStrings.length; i++) {
			System.out.println("\"" + testStrings[i] + "\" does " + (bb.hasBalancedBrackets(testStrings[i]) == 1 ? "" : "not ") + "have balanced brackets.");			
		}
		
	}
	
	/*
	 * Determine if the given string has balanced brackets. Each opening bracket must have
	 * a corresponding closing bracket, taking nested brackets into account.
	 * Returns 1 if all brackets are balanced, 0 otherwise.
	 */
	private int hasBalancedBrackets(String str) {
		Stack<Character> brackets = new Stack<Character>();
		if (str == null || str.isEmpty()) {
			return 1; // Empty string is balanced.
		} else {			
			for (int i = 0; i < str.length(); i++) {
				if (isOpeningBracket(str.charAt(i))) {
					brackets.push(str.charAt(i));
				} else if (isClosingBracket(str.charAt(i))){
					if (brackets.isEmpty()) {
						// Closing bracket found, while no matching opening bracket exists on the stack.
						return 0; 
					}
					if (brackets.pop() != matchingOpeningBracket(str.charAt(i))) {
						// Closing bracket found which does not match the corresponding opening bracket.
						return 0;
					}
				}
			}
			// If the whole string has been checked and no opening brackets remain on the stack -> string is balaned.
			return (brackets.isEmpty() ? 1 : 0);
		}
	}

	/*
	 * Checks if the given character is considered an opening bracket.
	 */
	private boolean isOpeningBracket(char c) {
		switch (c) {
			case '(': return true;
			case '{': return true;
			case '[': return true;
			case '<': return true;
		}
		return false;
	}
	
	/*
	 * Checks if the given character is considered a closing bracket.
	 */
	private boolean isClosingBracket(char c) {
		switch (c) {
			case ')': return true;
			case '}': return true;
			case ']': return true;
			case '>': return true;
		}
		return false;
	}
	
	/*
	 * Returns the opening bracket that matches the given closing bracket.
	 */
	private char matchingOpeningBracket(char c) {
		switch (c) {
			case ')': return '(';
			case '}': return '{';
			case ']': return '[';
			case '>': return '<';
		}
		return '\0'; // Return \0 in case the given character does not have a matching opening bracket.
	}
}