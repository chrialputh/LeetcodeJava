package Follow.N1_Rotate_Array_in_Java;

/*
 Bubble Rotate(气泡旋转)
 Can we do this in O(1) space? 我们可以在O (1)个空间中完成这个操作吗？
This solution is like a bubble sort  这个解决方案就像一个气泡类的
空间复杂度：O (1)
时间复杂度：O（n*k）。
 */
class Solution2 {
    void rotate(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        //冒泡交换数值
        for (int i = 0; i < order; i++) {   //控制冒泡循环次数
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];   //交换数值
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
}
