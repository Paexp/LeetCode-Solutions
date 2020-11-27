public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //找满足A[i-1]<A[i]>A[i+1]的i
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > arr[mid - 1]) {
                // mid落在上升区域 --> 山顶一定不在[left, mid - 1]
                // 下一个搜索区间为 [mid, right]
                left = mid;
            } else {
                // [left, mid - 1]
                right = mid - 1;
            }
        }
        return left;
    }
}