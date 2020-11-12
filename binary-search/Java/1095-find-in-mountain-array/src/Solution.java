/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 */

interface MountainArray {
    public int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}

public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 1. 找到山顶的下标
        int peekIndex = findPeakIndexInMountainArray(mountainArr);
        // 2. 左侧搜索target --> index1
        int index1 = findInLeftMountainArray(target, mountainArr, peekIndex);
        if (index1 != -1) {
            return index1;
        }
        // index1 == -1;
        // 3. 右侧搜索target --> index2
        int index2 = findInRightMountainArray(target, mountainArr, peekIndex);
        return index2;
    }

    /**
     * 找到山脉数组的下标
     *
     * @param mountainArr
     * @return
     */
    private int findPeakIndexInMountainArray(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid - 1)) {
                // [mid, right] 为下降阶段
                // 下一个搜索区间[left, mid - 1]
                right = mid - 1;
            } else {
                // [mid, right]
                left = mid;
            }
        }
        return left;
    }

    private int findInLeftMountainArray(int target, MountainArray mountainArr, int peekIndex) {
        int left = 0;
        int right = peekIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                // 下一个搜索区间[mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid - 1]
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int findInRightMountainArray(int target, MountainArray mountainArr, int peekIndex) {
        int left = peekIndex;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 这里如果写成mountainArr.get(mid) < target，
            // 后面对应的逻辑会不对，有待进一步研究
            if (mountainArr.get(mid) > target) {
                // 下一个搜索区间[mid + 1, right]
                left = mid + 1;
            } else {
                // [left, mid - 1]
                right = mid;
            }
        }

        if (mountainArr.get(left) == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 5, 3, 1};
        int target = 3;
        MountainArrayImpl mountainArray = new MountainArrayImpl(array);
        Solution solution = new Solution();
        int ans = solution.findInMountainArray(target, mountainArray);
        System.out.println(ans);
    }
}