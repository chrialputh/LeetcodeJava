package Follow.N3_Longest_Palindromic_Substring;
/*
天真地，我们可以简单地检查每个子字符串，并检查它是否为回文的。时间复杂度为O（nˆ3）
如果这是提交给LeetCode在线判断，将返回一个错误消息-“超过时间限制”。
因此，这种方法只是一个开始，我们需要一个更好的算法。
 */
class Solution1 {
    String longestPalindrome1(String s) {
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();
        // 检查所有可能的子字符串
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;
                String curr = s.substring(i, j + 1);
                if (isPalindrome(curr)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }
    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
