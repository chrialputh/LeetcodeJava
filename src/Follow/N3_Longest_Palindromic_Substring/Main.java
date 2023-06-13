package Follow.N3_Longest_Palindromic_Substring;
/*
寻找最长的回文子串是编码面试的一个经典问题。
在这篇文章中，我将总结出针对这个问题的3种不同的解决方案。
 */
public class Main {
    public static void main(String[] args) {
        String s = "absdfggfdsbbsd";
        String s1 = "eebsnlmn";

        final Solution2 solution2 = new Solution2();
        System.out.println("solution2  " + solution2.longestPalindrome(s));
        final Solution3 solution3 = new Solution3();
        System.out.println("solution3  " + solution3.longestPalindrome(s));
        final Solution1 solution1 = new Solution1();
        System.out.println("solution1  " + solution1.longestPalindrome(s));

    }
}
