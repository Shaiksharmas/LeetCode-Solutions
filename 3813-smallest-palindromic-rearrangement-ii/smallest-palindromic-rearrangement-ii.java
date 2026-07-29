class Solution {
    private static final long LIMIT = 1000001L;

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        String mid = "";
        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) mid = String.valueOf((char) ('a' + i));
            half[i] = cnt[i] / 2;
            len += half[i];
        }

        if (countWays(half, len) < k) return "";
        StringBuilder left = new StringBuilder();
        while (len > 0) {
            for (int i = 0; i < 26; i++) {
                if (half[i] == 0) continue;

                half[i]--;
                long ways = countWays(half, len - 1);

                if (ways >= k) {
                    left.append((char) ('a' + i));
                    len--;
                    break;
                } else {
                    k -= ways;
                    half[i]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long res = 1;
        int rem = total;

        for (int x : cnt) {
            if (x == 0) continue;
            res *= comb(rem, x);
            if (res > LIMIT) return LIMIT;
            rem -= x;
        }

        return Math.min(res, LIMIT);
    }

    private long comb(int n, int r) {
        r = Math.min(r, n - r);
        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > LIMIT) return LIMIT;
        }

        return Math.min(res, LIMIT);
    }
}