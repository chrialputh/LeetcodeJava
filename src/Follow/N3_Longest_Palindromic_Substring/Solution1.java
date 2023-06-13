package Follow.N3_Longest_Palindromic_Substring;

/*
天真地，我们可以简单地检查每个子字符串，并检查它是否为回文的。时间复杂度为O（nˆ3）
如果这是提交给LeetCode在线判断，将返回一个错误消息-“超过时间限制”。
因此，这种方法只是一个开始，我们需要一个更好的算法。
 */
class Solution1 {
    String longestPalindrome(String s) {
        int maxPalinLength = 0;  //定义最长回文字符串长度
        String longestPalindrome = null;   //定义最长回文字符串对象
        int length = s.length();     //获取s的长度
        // 检查所有可能的子字符串
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;  //获取子字符串的长度
                String curr = s.substring(i, j + 1);
                /*
                substring(int beginIndex, int endIndex)
                返回一个字符串，该字符串是此字符串的子字符串。
                子串开始于指定beginIndex（包括beginIndex），并延伸到字符索引endIndex - 1 。
                因此，子串的长度为endIndex-beginIndex
                 */
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

    //判断字符串是否会文的函数
    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {   //双数i到一半，单数i到（单数-1）的一半
            //为了让算法更快这里以判断不相等为条件，只要发现不对等就返回false，后面不再检查
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {  //（s.length() - 1）减i是为了与i指向的元素同步
                //java.lang.String.charAt() 方法返回指定索引处的char值。索引范围是从0到length() - 1
                return false;
            }
        }
        //当for循环中都满足时，返回true。
        return true;
    }
}
