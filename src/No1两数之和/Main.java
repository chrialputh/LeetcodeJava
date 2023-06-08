package No1两数之和;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] ints = {1, 4, 5, 6, 87, 9, 64, 89, 73, 93, 7, 75, 35, 76, 34};
        final int target = 43;
        final Solution solution = new Solution();
        final SolutionPro solutionPro = new SolutionPro();

        long l = System.currentTimeMillis();
        System.out.println(Arrays.toString(solution.twoSum(ints, target)));
        //将数组转化字符串并输出，Arrays.toString(数组名（数组地址）)
        long l2 = System.currentTimeMillis();
        System.out.println("暴力枚举法所使用的时间" + (l2 -l));

        long l3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(solutionPro.twoSum(ints, target)));
        long l4 = System.currentTimeMillis();
        System.out.println("哈希法所使用的时间" + (l4 -l3));

        System.out.println("哈希法比暴力枚举法快" + (l2 - l - l4 + l3));
    }
}
