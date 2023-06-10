package Follow.N1_Rotate_Array_in_Java;
/* Intermediate Array(中间数组)
我们可以以一种简单的方式创建一个新的数组，
然后将元素复制到新的数组中。
然后使用System.arraycopy()更改原始数组。
时间复杂度：O（n）
空间复杂度：O（2n）
 */

class Solution1 {
    void rotate(int[] nums, int k) {

        if (k > nums.length)

            k = k % nums.length;

        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
            //加i是因为要将后面的每一个要反转到前面的元素与前面的下标对齐
        }
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            //i指向新建数组后面的位置；j用于原始数组，指向前面待移动
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
        /*
        第一个参数是要被复制的数组
        第二个参数是被复制的数字开始复制的下标
        第三个参数是目标数组，也就是要把数据放进来的数组
        第四个参数是从目标数据第几个下标开始放入数据
        第五个参数表示从被复制的数组中拿几个数值放到目标数组中
         */
    }
}
