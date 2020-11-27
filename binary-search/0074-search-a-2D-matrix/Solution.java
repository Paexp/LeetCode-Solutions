/**
 * @author expev
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        // 两轮二分查找
        // 1.第一轮：matrix[0][0] ~ matrix[m - 1][0] --> 确定行号
        // 查找最接近但小于等于target的行号
        int rleft = 0, rright = m - 1;
        while (rleft <= rright) {
            int mid = rleft + (rright - rleft) / 2;
            int cur = matrix[mid][0];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                // 下一个搜索区间：[mid + 1, right]
                rleft = mid + 1;
            } else {
                // [left, mid - 1]
                rright = mid - 1;
            }
        }

        if (rright == -1) {
            return false;
        }
        int row = rright;

        // 2.第二轮：matrix[row][n - 1] ~ matrix[row-1][n - 1] --> 确定列号
        int cleft = 0, cright = n - 1;
        while (cleft <= cright) {
            int mid = cleft + (cright - cleft) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                // 下一个搜索区间[cleft, mid - 1]
                cright = mid - 1;
            } else {
                // [mid+1, cright]
                cleft = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        //int[][] matrix = {{}};
        int target = 11;
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
