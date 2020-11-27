public class Solution {
    /**
     * 寻找大于等于target的第一个数的位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target) {
            return 0;
        }
        if (nums[length - 1] < target) {
            return length;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // [mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid]
                right = mid;
            }
        }
        return left;
    }
}