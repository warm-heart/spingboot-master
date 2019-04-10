package StackAndQueue;



/**
 * @author wangqianlong
 * @create 2019-04-08 18:48
 *
 * LeetCode 第20题
 */

public class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();   //使用自己的stack 也可以使用jdk提供的stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topChar = (char) stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("()[{}"));
    }
}
