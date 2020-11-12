public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 和右边界比较，判断区间[mid, right]是否有序
            if (nums[mid] < nums[right]) {
                // [mid + 1, right]有序
                if (nums[mid + 1] <= target && target <= nums[right]) {
                    // 下一个搜索区间[mid + 1, right]
                    left = mid + 1;
                } else {
                    // [left, mid]
                    right = mid;
                }
            } else if (nums[mid] > nums[right]) {
                // [left, mid]有序
                if (nums[left] <= target && target <= nums[mid]) {
                    // 下一个搜索区间[left, mid]
                    right = mid;
                } else {
                    // [mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // mid == right, 无法判断
                // right --
                if (nums[right] == target) {
                    return true;
                }
                right--;
            }
        }
        if (nums[left] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.search(nums,target));
    }
}
