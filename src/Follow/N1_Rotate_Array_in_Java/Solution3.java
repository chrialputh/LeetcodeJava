package Follow.N1_Rotate_Array_in_Java;

/*
Can we do this in O(1) space and in O(n) time?    我们可以在O (1)空间和O (n)时间中完成这个任务吗？
The following solution does.                      下面的解决方案做到了
Assuming we are given 1,2,3,4,5,6 and order 2.    假设我们得到了123456和k = 2
The basic idea is                                 其基本思想是
1. Divide the array two parts: 1,2,3,4 and 5, 6   1.将数组分成两部分：1234和56
2. Rotate first part: 4,3,2,1,5,6                 2旋转第一部分：4、3、2、1、5、6
3. Rotate second part: 4,3,2,1,6,5                3旋转第二部分：4、3、2、1、6、5
4. Rotate the whole array: 5,6,1,2,3,4            4旋转整个阵列：5、6、1、2、3、4
2, 3, 4步骤都是重复的操作，可以写成函数
 */
class Solution3 {
    void rotate(int[] arr, int order) {
        order = order % arr.length;
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
//length of first part
        int a = arr.length - order;
        reverse(arr, 0, a - 1);  //旋转第一部分
        reverse(arr, a, arr.length - 1);  //旋转二部分
        reverse(arr, 0, arr.length - 1);  //旋转第三部分
    }

    void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return ;
        //向中靠拢，对称交换数值，通过两个指针left 和 right
        while (left < right) {  //left == right时，表示中间元素，不必旋转
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
