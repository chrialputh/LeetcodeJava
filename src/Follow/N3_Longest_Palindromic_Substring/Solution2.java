package Follow.N3_Longest_Palindromic_Substring;

/*
设s是输入字符串，i和j是字符串的两个索引。
定义一个二维数组“table”，让表表示从i到j的子字符串是否为回文。
开始条件：
table[i][i] == 1;
table[i][i+1] == 1 => s.charAt(i) == s.charAt(i+1)
变化条件：
table[i+1][j-1] == 1  && s.charAt(i) == s.charAt(j)   =>    table[i][j] == 1
解释：
s.charAt(i) == s.charAt(j) 两端相同
table[i+1][j-1] == 1 解释：最长回文字符串，去掉两头依旧是回文

给定一个输入，我们可以在每次迭代后使用打印表方法来检查表。
例如，如果输入字符串是“dabcba”，最长子字符串（abcba,下标从1到5，[2][4]也为 1 ，即 [1][5]去掉两端的字符也是回文）
最终的矩阵将如下：
1 0 0 0 0 0
0 1 0 0 0 1
0 0 1 0 1 0
0 0 0 1 0 0
0 0 0 0 1 0
0 0 0 0 0 1
从表中，我们可以清楚地看到，最长的字符串在单元格表[1][5]中。
时间O（nˆ2）
空间O（nˆ2）
 */
class Solution2 {
    String longestPalindrome(String s) {
        //安全性检查，
        if (s.isEmpty())
            return null;
        if (s.length() <= 1)
            return s;
        int maxLen = 0;  //定义最长回文字符串长度
        String longestStr = null;  //定义最长回文字符串对象
        int length = s.length();  // //获取s的长度
        int[][] table = new int[length][length];  //创建二位数组
        //1，每一个字母都是回文的
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        printTable(table);  //输出当前二位数组情况

        //2，两个连续的相同字母是回文字母  例如：hcjj
        for (int i = 0; i < length - 1; i++) {   //符合上面的“变化条件”
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2); //截取此字符串
            }
        }
        printTable(table);  //输出当前二位数组情况
        //3，三种以上回文判断
        for (int l = 3; l <= length; l++) {
            // l 变量表示了回文字符串的长度，以上分别处理了长度为 "1" 和 "2" 的情况，下面就处理长度为 "3"和 "s的长度"
            for (int i = 0; i <= length - l; i++) {  //i开始移动，并小于length - l
                int j = i + l - 1;   //定位j的位置
                if (s.charAt(i) == s.charAt(j)) {
                    //若两个位置字符相等，就将他的数组值 赋值为 其去掉两端后对应的数组值
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen)  //其去掉两端后对应的数组值 若不为 “1” 就说明外层也不是回文的
                        //这里与maxlen变量进行力比较，因为牵扯到多种长度的回文字符串，故要进行比较，
                        // 而上面两个for循环只有一种长度，所以不用比较
                        longestStr = s.substring(i, j + 1);  //截取回文字符串
                } else {
                    //若两个位置字符不相等，就把他置 “0”
                    table[i][j] = 0;
                }
                printTable(table);  //输出当前二位数组情况
            }
        }
        return longestStr;
    }

    void printTable(int[][] x) {
        //两个for循环遍历二维数组，输出数组内容
        for (int[] y : x) {
            for (int z : y) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
        //数组内容输出完后，输出分割线
        System.out.println("------");
    }
}
