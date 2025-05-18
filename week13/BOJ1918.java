import java.io.*;
import java.util.*;

public class BOJ1918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();
        StringBuilder postfix = new StringBuilder();
        Deque<Character> oper = new LinkedList<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                postfix.append(c);
            } else if (c == '(') {
                oper.addLast(c);
            } else if (c == ')') {
                while (!oper.isEmpty() && oper.peekLast() != '(') {
                    postfix.append(oper.pollLast());
                }
                oper.pollLast();
            } else {
                while (!oper.isEmpty() && prec(oper.peekLast()) >= prec(c)) {
                    postfix.append(oper.pollLast());
                }
                oper.addLast(c);
            }
        }

        while (!oper.isEmpty()) {
            postfix.append(oper.pollLast());
        }

        System.out.println(postfix);
    }

    public static int prec(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
