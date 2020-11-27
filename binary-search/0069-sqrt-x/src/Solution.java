public class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            long square = mid * mid;
            if (square > x) {
                // [left, mid - 1]
                right = mid - 1;
            } else {
                // [mid, right]
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        int x = 1;
        Solution solution = new Solution();
        int ans = solution.mySqrt(x);
        System.out.println(ans);
    }
}
