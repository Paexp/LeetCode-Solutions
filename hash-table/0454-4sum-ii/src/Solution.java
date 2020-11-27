import java.util.HashMap;
import java.util.Map;

/**
 * @author expev
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                countAB.put(a + b, countAB.getOrDefault(a + b, 0) + 1);
            }
        }

        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                if (countAB.containsKey(-c - d)) {
                    ans += countAB.get(-c - d);
                }
            }
        }
        return ans;
    }
}
