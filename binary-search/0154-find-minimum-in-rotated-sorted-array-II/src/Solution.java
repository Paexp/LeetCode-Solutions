public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] < nums[right]) {
                // [mid, right]有序
                // 下一个搜索区间[left, mid]
                right = mid;
            } else if (nums[mid] > nums[right]){
                // [left, mid]有序
                // 下一个搜索区间[mid + 1, right]
                left = mid + 1;
            } else {
                // mid == right
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,0,1,1};
        Solution solution = new Solution();
        System.out.println(solution.findMin(nums));
    }
}