package No1两数之和;

import java.util.HashMap;
import java.util.Map;

class SolutionPro {
    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;
        //指定哈希表的容量为length - 1 因为最坏情况是判断到length - 1，
        Map<Integer, Integer> hashMap = new HashMap<>(length - 1);
        hashMap.put(nums[0], 0);  //把首个元素存入哈希表，数值作为"key" 下标作为 "value"
        for (int i = 1; i < length; i++) {  //从第二个元素开始判断
            int key = target - nums[i];   //target - nums[i] 常用就把这个值存入一个变量中；
            //在每遍历一个新元素之前，都会去在哈希表中检查键值是否存在与"key"相等
            if (hashMap.containsKey(key)) {
                return new int[]{hashMap.get(key), i};
                //hashMap.get(key)：返回简直key对应的value（即目标下标）
            }
            hashMap.put(nums[i], i);  //若元素所对应的值不在哈希表中，那就把元素存到哈希表中
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}