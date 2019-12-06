package com.structures.linear.stack;


import java.util.Stack;

/**
 * 给定一个字符串,返回是否合法,例如:"()())" 返回false  "(())" 返回true
 * <p>
 * 利用栈来解决该问题
 *
 * @author tanjiang
 */
public class ValidParenthesis {

    public static void main(String[] args) {
//        System.out.println(isValid0("(()))"));

        System.out.println(longestValidParentheses1("()(())"));
    }

    /**
     * 该算法的时间复杂度为O(n),因为除了自身占用内存,还申请了一个栈,所以空间复杂度为O(n)
     *
     * @param s 待校验字符串
     * @return 是否合法字符串
     */
    private static boolean isValid0(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        //额外申请了一个栈结构,栈结构是一个线性的数据结构,空间复杂度为O(n)
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                //如果为'）',而且栈又为空,说明该字符串不满足要求,直接返回false
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 优化使得空间复杂度为O(1)
     *
     * @param s 待校验字符串
     * @return 是否合法字符串
     */
    private static boolean isValid1(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        //用num 表示'（'的个数。
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num++;
            } else {
                //如果为'）',而且栈又为空,说明该字符串不满足要求,直接返回false
                if (num == 0) {
                    return false;
                } else {
                    num--;
                }
            }
        }
        return num == 0;
    }


    /**
     * 找到字符串中最长有效括号   "()(())()"  "(())" 返回4
     * 时间空间复杂度都为O(n)
     *
     * @param s 目标串
     * @return 最长后效括号长度
     */
    private static int longestValidParentheses0(String s) {

        int max = 0;

        //栈来保存'('的下标
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }


    /**
     * 找到字符串中最长有效括号   "()(())()"  "(())" 返回4
     * 时间复杂度都为O(n),空间复杂度为O(1)
     *
     * @param s 目标串
     * @return 最长后效括号长度
     */
    private static int longestValidParentheses1(String s) {

        //左括号的个数
        int left = 0;
        //右括号的个数
        int right = 0;

        int max = 0;

        //从左开始遍历
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            //如果 left >= right，显然这个时候 right 个 ')' 都将一定能够得到匹配。所以当前的有效括号长度为 2 * right。然后更新 max。
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (left < right) {
                left = right = 0;
            }
        }

        //从右开始遍历
        left = right = 0;
        for (int j = s.length() - 1; j > 0; j--) {
            if (s.charAt(j) == '(') {
                left++;
            } else {
                right++;
            }

            //如果 left <= right，显然这个时候 left 个 ')' 都将一定能够得到匹配。所以当前的有效括号长度为 2 * left。然后更新 max。
            if (left == right) {
                max = Math.max(max, left * 2);

            } else if (left > right) {
                left = right = 0;
            }
        }

        return max;
    }

}
