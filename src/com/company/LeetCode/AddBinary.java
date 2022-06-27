package com.company.LeetCode;

public class AddBinary {
    /**
     * �����Ƽӷ�
     * �������� 01 �ַ��� a �� b ����������ǵĺͣ����Զ������ַ�������ʽ�����
     *
     * ����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0��
     * ����: a = "11", b = "10"
     * ���: "101"
     * ��ʾ��
     *
     * ÿ���ַ��������ַ� '0' �� '1' ��ɡ�
     * 1 <= a.length, b.length <= 10^4
     * �ַ���������� "0" ���Ͷ�����ǰ���㡣
     *
     * ע�⣺��������վ 67?����ͬ��https://leetcode-cn.com/problems/add-binary/
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a,String b){
        String result = "";
        if (a.length()<1||b.length()>Math.pow(10,4)){
            return "0";
        }
        // ģ��ӷ�
        int first = a.length();int second = b.length();int mid = 0;
        int n = Math.max(first,second);
        for (int i = 0; i < n; ++i) {
           mid = mid+ (i<a.length()?(a.charAt(first-1-i)-'0'):0);
           mid = mid+ (i<b.length()?(b.charAt(second-1-i)-'0'):0);
           result = result+(char)(mid%2+'0');
           mid = mid/2;
        }
        if (mid>0){
            result = result+'1';
        }
        return new StringBuffer(result).reverse().toString();
    }

    /**
     * �� aa �� bb ת������������ xx �� yy���ڽ������Ĺ����У�xx ��������yy �����λ��
     * ����λ��Ϊ 00 ʱ
     * ���㵱ǰ xx �� yy ���޽�λ��ӽ����answer = x ^ y
     * ���㵱ǰ xx �� yy �Ľ�λ��carry = (x & y) << 1
     * ��ɱ���ѭ�������� x = answer��y = carry
     * ���� xx �Ķ�������ʽ
     * Ϊʲô��������ǿ��е��أ��ڵ�һ�ּ����У�answer �����һλ�� xx �� yy ���֮��Ľ����
     * carry �ĵ����ڶ�λ�� xx �� yy ���һλ��ӵĽ�λ��
     * ����ÿһ���У����� carry ���� xx �� yy ��λ�벢�����Ƶõ��ģ�
     * ��ô���Ჹ�㣬�������������Ĺ����к������λ����Ӱ�죬
     * ��ÿһ�ֶ����Եõ�һ���� ii λ�Ĵ𰸺������ i + 1i+1 λ�Ľ�λ��Ҳ��ģ���˼ӷ��Ĺ��̡�
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a,String b){
        // ���ķ�����^����λ�������, �Եȳ�������ģʽ��λ�����������ÿһλִ���߼���λ������. �����Ľ�������ĳλ��ͬ���λΪ1, �����λΪ0.
        // ����������������������Ҳ����˵�������ͬһ������������䣬����a ^ b) ^ b = a
        // todo ��������һ�����ǣ��ַ�����111������֮�󣬱���Ϊ��ʮ���Ƶ�111Int�������������㣬��ôӦ����ν�111�ַ���ת��Ϊ111�����ƽ��������أ�
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        while (y!=0){
            int temp = x^y;
            y = (x&y)<<1;
            x = temp;
        }
        return Integer.toBinaryString(x);
    }

    public static void main(String[] args) {
        System.out.println(addBinary1("11","10"));
        System.out.println(11&10);
        System.out.println((11&10) << 1);
        System.out.println(Integer.toBinaryString(1111));
    }
}
