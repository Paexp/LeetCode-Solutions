public class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 判断mid的右区间是否有序
            if (nums[mid] < nums[right]) {
                // [mid, right] 有序
                if (nums[mid] <= target && target <= nums[right]) {
                    // target落在[mid, right]内
                    left = mid;
                } else {
                    // [left, mid - 1]
                    right = mid - 1;
                }
            } else {
                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
                // 我们故意只认为 [left, mid - 1] 有序
                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                // 此时 mid - 1 不会越界，就是这么刚刚好

                if (nums[left] <= target && target <= nums[mid - 1]) {
                    // target落在[left, mid]内
                    right = mid - 1;
                } else {
                    // [mid + 1, right]
                    left = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int target = 1;
        Solution solution = new Solution();
        int ans = solution.search(nums, target);
        System.out.println(ans);
    }
}
