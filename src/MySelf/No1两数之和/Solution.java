package MySelf.No1两数之和;

/*
时间复杂度：O(N²)
空间复杂都：O(1)
暴力枚举法
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
