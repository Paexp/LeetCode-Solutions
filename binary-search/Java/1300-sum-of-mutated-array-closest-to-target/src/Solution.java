public class Solution {
    // 单调性：value越大 --> sum越大
    // 寻找第一个大于target的sum对应的value
    public int findBestValue(int[] arr, int target) {
        // 1.确定搜索区间 [0, arr_max]
        int left = 0;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num);
        }

        // 2.二分答案 left, right
        while (left < right) {
            // 计算value对应的sum --> sumOfMutatedArray
            // 寻找第一个大于target的sum对应的value
            int mid = left + (right - left) / 2;
            int sumOfMutatedArray = calculateSum(arr, mid);
            if (sumOfMutatedArray < target) {
                // 这里要细心，严格小于意味着mid一定不是解，搜索区间从mid+1开始
                // 下一个搜索区间[mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid]
                right = mid;
            }
        }
        int value = left;

        // 3. 比较value - 1 和value哪个更加接近target
        if (calculateSum(arr, value) - target >= target - calculateSum(arr, value - 1)) {
            return value - 1;
        } else {
            return value;
        }
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5};
        int target = 10;
        Solution solution = new Solution();
        int ans = solution.findBestValue(arr, target);
        System.out.println(ans);
    }
}
