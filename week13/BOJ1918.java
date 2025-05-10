package week13;

import java.io.*;
import java.util.*;

public class BOJ1918 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();

		System.out.println(topostfix(str));
	}

	static String topostfix(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char c : str.toCharArray()) {
			if (isAlphabet(c)) { // 알파벳이면 바로 입력
				sb.append(c);
			} else if (c == '(') { // 여는 괄호 나오면 스택에 저장
				stack.push(c);
			} else if (c == ')') { // 닫는 괄호 나오면
				while (!stack.isEmpty() && stack.peek() != '(') { // 여는 괄호 전까지
					sb.append(stack.pop()); // 스택에서 빼서 입력
				}
				stack.pop();
			} else if (isOperater(c)) { // 연산자인 경우
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
					sb.append(stack.pop()); // 스택에 들어있는 연산자가 현재 연산자보다 우선순위가 높으면 스택에서 꺼내서 입력
				}
				stack.push(c); // 연산자를 스택에 저장
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()); // 나머지 연산자 후위표기로 입력
		}

		return sb.toString();
	}

	static boolean isAlphabet(char c) { // 알파벳 대문자가 숫자 대용이므로 판단
		return c - 'A' >= 0 && c - 'A' <= 26;
	}

	static boolean isOperater(char c) { // 연산자인지 판단
		return c == '*' || c == '/' || c == '+' || c == '-';
	}

	static int priority(char c) { // 연산자 우선순위 판단
		if (c == '+' || c == '-')
			return 1;
		if (c == '/' || c == '*')
			return 2;
		return 0;
	}
}
