package com.company.LeetCode.Stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * * 左括号必须用相同类型的右括号闭合。
 * * 左括号必须以正确的顺序闭合。
 * * 注意空字符串可被认为是有效字符串。
 *
 * @Author: RenHe
 * @Date: 2021/6/4 15:32
 */
public class IsValid {
    public static void main(String[] args) {
        String str = "[{{()(){}}}[])(]";
        isValid(str);
    }

    public static boolean isValid(String str) {
        boolean isValid = false;
        if (str==null||str.equals("")){
            System.out.println("有效字符串");
            return true;
        }
        char[] charArr = str.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < charArr.length; i++) {
            char thisChar = charArr[i];
            if (!stack.empty()) {
                char topChar = (char) stack.peek();
                if ('('==topChar && ')'==thisChar) {
                    System.out.println("()出栈");
                    stack.pop();
                } else if ('{'==topChar && '}'==thisChar) {
                    System.out.println("{}出栈");
                    stack.pop();
                } else if ('['==topChar && ']'==thisChar) {
                    System.out.println("[]出栈");
                    stack.pop();
                } else {
                    stack.push(thisChar);
                    System.out.println(thisChar + "入栈");
                }
            } else {
                stack.push(thisChar);
                System.out.println(thisChar + "入栈");
            }
        }
        if (!stack.empty()) {
            System.out.println("非有效字符串");
            isValid = false;
        }else{
            System.out.println("有效字符串");
            isValid = true;
        }
        return isValid;

    }
}




















