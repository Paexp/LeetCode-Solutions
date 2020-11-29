import java.util.Arrays;

/**
 * @author expev
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        // 特判：A.length < 3; A == null
        if (A == null || A.length < 3) {
            return 0;
        }

        // 1. 排序
        Arrays.sort(A);

        // 2. 从A[i]倒序遍历，如果A[i-2]+A[i-1]>A[i]，则return
        //    否则--i
        for (int i = A.length - 1; i > 1; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}