class GuessGame {
    private static final int PICK = 6;

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    int guess(int num) {
        if (num == PICK) {
            return 0;
        } else if (num > PICK) {
            return -1;
        }
        return 1;
    }
}


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int guessNum = guess(mid);
            if (guessNum == -1) {
                // mid > pick --> [left, mid - 1]
                right = mid - 1;
            } else {
                // [mid, right]
                left = mid;
            }
        }
        return left;
    }
}
