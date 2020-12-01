/**
 * @author expev
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        int firstPosition = searchFirstPosition(nums, target);
        // 不存在则返回值为-1, 需要增加判断
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = searchLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    /**
     * 找到第一个等于target的下标
     *
     * @param nums
     * @param target
     * @return
     */
    private int searchFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
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
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 找到最后一个等于target的下标
     *
     * @param nums
     * @param target
     * @return
     */
    private int searchLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // [left, mid - 1]
                right = mid - 1;
            } else {
                // [mid, right]
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution solution = new Solution();
        int[] ans = solution.searchRange(nums, target);
        for (int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }
    }
}
