/**
 * @author expev
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                // left左边始终为非0数
                left++;
            }
            // right去搜索为0数
            right++;
        }
    }

    // 交换nums中下标为left和right的数
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
