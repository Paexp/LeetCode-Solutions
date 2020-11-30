import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author expev
 */
public class Solution {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxcount = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxcount = Math.max(maxcount, counts[c - 'a']);
        }

        // 如果可以重新排布成相邻的字母都不相同的字符串，每个字母最多出现（n+1）/2次
        if (maxcount > (n + 1) / 2) {
            return "";
        }

        // 维护一个最大堆存储字母，堆顶元素为出现次数最多的字母
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });

        // 将所有出现的字母都加入堆中
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();

        // 每次选择两个字母放到字符串尾部
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            counts[letter1 - 'a']--;
            counts[letter2 - 'a']--;
            sb.append(letter1);
            sb.append(letter2);

            // 数组仍然存在字母，则再次加入堆中
            if (counts[letter1 - 'a'] > 0) {
                queue.offer(letter1);
            }
            if (counts[letter2 - 'a'] > 0) {
                queue.offer(letter2);
            }
        }

        // 最后剩下一个，直接放到字符串尾部
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
