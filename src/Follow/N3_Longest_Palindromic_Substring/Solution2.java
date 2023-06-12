package Follow.N3_Longest_Palindromic_Substring;
/*
设s是输入字符串，i和j是字符串的两个索引。
定义一个二维数组“table”，让表表示从i到j的子字符串是否为回文。
开始条件：
table[i][i] == 1;
table[i][i+1] == 1 => s.charAt(i) == s.charAt(i+1)
变化条件：
table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)
=>
table[i][j] == 1
时间O（nˆ2）
空间O（nˆ2）
 */
class Solution2 {
    String longestPalindrome2(String s) {
        if (s == null)
            return null;
        if(s.length() <=1)
            return s;
        int maxLen = 0;
        String longestStr = null;
        int length = s.length();
        int[][] table = new int[length][length];
//every single letter is palindrome
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        printTable(table);
//e.g. bcba
//two consecutive same letters are palindrome
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)){
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        printTable(table);
//condition for calculate whole table
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length-l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen)
                        longestStr = s.substring(i, j + 1);
                } else {
                    table[i][j] = 0;
                }
                printTable(table);
            }
        }
        return longestStr;
    }

    void printTable(int[][] x){
        for(int [] y : x){
            for(int z: y){
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}
/*
给定一个输入，我们可以在每次迭代后使用打印表方法来检查表。
例如，如果输入字符串是“dabcba”，最终的矩阵将如下：
1 0 0 0 0 0
0 1 0 0 0 1
0 0 1 0 1 0
0 0 0 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
从表中，我们可以清楚地看到，最长的字符串在单元格表[1][5]中。
 */