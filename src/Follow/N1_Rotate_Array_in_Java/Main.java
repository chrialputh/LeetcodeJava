package Follow.N1_Rotate_Array_in_Java;

import java.util.Arrays;

/*
Problem: Rotate an array of n elements to the right by k steps. For example,
with n= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
How many different ways do you know to solve this problem?
问题：通过k步，向右旋转n个元素的数组。
例如，使用n = 7和k = 3，数组[1,2,3,4,5,6,7]被旋转到[5,6,7,1,2,3,4]。
你知道有多少种不同的方法来解决这个问题？
 */
public class Main {
    public static void main(String[] args) {
        final Solution1 solution1 = new Solution1();
        final Solution2 solution2 = new Solution2();
        final Solution3 solution3 = new Solution3();
        int[] ints = {1, 3, 4, 5, 6, 7, 8, 9};
        //solution1.rotate(ints, 3);
        //System.out.println("解决方案1: " + Arrays.toString(ints));
        //solution2.rotate(ints, 3);
        //System.out.println("解决方案2: " + Arrays.toString(ints));
        solution3.rotate(ints, 4);
        System.out.println("解决方案3: " + Arrays.toString(ints));
    }
}
