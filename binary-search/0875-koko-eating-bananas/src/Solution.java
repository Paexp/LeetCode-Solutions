public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // 搜索区间[1, pile_max]
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hour = calculateHour(piles, mid);
            if (hour > H) {
                // 耗时大于h，加快速度
                // 下一个搜索区间[mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid]
                right = mid;
            }
        }
        return left;

    }

    private int calculateHour(int[] piles, int speed) {
        int hour = 0;
        for (int pile : piles) {
            // 向上取整，一次吃speed个，不够也算一小时
            hour += (pile + speed - 1) / speed;
        }
        return hour;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int H = 8;
        Solution solution = new Solution();
        int k = solution.minEatingSpeed(piles, H);
        System.out.println(k);
    }
}
