package com.company.LeetCode.Stack;

import java.util.Stack;

/**
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ������ж��ַ����Ƿ���Ч��
 * <p>
 * ��Ч�ַ��������㣺
 * * �����ű�������ͬ���͵������űպϡ�
 * * �����ű�������ȷ��˳��պϡ�
 * * ע����ַ����ɱ���Ϊ����Ч�ַ�����
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
            System.out.println("��Ч�ַ���");
            return true;
        }
        char[] charArr = str.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < charArr.length; i++) {
            char thisChar = charArr[i];
            if (!stack.empty()) {
                char topChar = (char) stack.peek();
                if ('('==topChar && ')'==thisChar) {
                    System.out.println("()��ջ");
                    stack.pop();
                } else if ('{'==topChar && '}'==thisChar) {
                    System.out.println("{}��ջ");
                    stack.pop();
                } else if ('['==topChar && ']'==thisChar) {
                    System.out.println("[]��ջ");
                    stack.pop();
                } else {
                    stack.push(thisChar);
                    System.out.println(thisChar + "��ջ");
                }
            } else {
                stack.push(thisChar);
                System.out.println(thisChar + "��ջ");
            }
        }
        if (!stack.empty()) {
            System.out.println("����Ч�ַ���");
            isValid = false;
        }else{
            System.out.println("��Ч�ַ���");
            isValid = true;
        }
        return isValid;

    }
}




















