package week01;

import java.util.Stack;

// 第 2 课 栈、队列
// 有效的括号
//leetcode submit region begin(Prohibit modification and deletion)
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // 字符串为空，返回false
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }

        // 字符串不为空，依次遍历
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {  // 遇到左括号，入栈
                stack.push(c);
            } else {
                if (stack.empty()) { // 如果栈为空，返回false
                    return false;
                }
                if (c == ')' && stack.pop() != '(') { // 遇到反括号，则出栈，并判定入栈是否匹配
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }

        return stack.empty(); // 最后判定栈是否为空，如果为空，说明匹配完成。
    }

    public static void main(String[] args) {
        ValidParentheses s=new ValidParentheses();
        boolean valid = s.isValid("{[]}");
        System.out.println(valid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
