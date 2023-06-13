package Follow.N3_Longest_Palindromic_Substring;

/*
简单算法
找中心，向两边扩散
时间O（nˆ2），空间O (1)
 */
class Solution3 {
    String longestPalindrome(String s) {
        //安全性检查，
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        /*
        回文有俩个情况：aba式 和 abba式，
        通过写一个 由中心向外判断回文的helper函数，来对每一次遍历的中心进行判断，
        helper返回判断后的回文字符串，使用if语句进行 返回结果与longest 比较，并更新longest的值
         */
        for (int i = 0; i < s.length(); i++) {  //for循环遍历s
            // 得到以i为中心的最长回文  aba式的情况
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            // 得到以i,i+1为中心的最长回文  abba式的情况
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    //给定一个中心，一个字母或两个字母，
    // 查找最长回文
    String helper(String s, int begin, int end) { //begin 和 end 是下标
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) ==
                s.charAt(end)) {
            begin--; //向外扩散
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
