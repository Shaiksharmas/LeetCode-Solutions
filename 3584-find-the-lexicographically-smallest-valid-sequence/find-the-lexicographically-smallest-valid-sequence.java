class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];
        suf[n] = m;

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int idx = 0;
        int p = 0;
        boolean used = false;

        for (int i = 0; i < n && p < m; i++) {
            if (word1.charAt(i) == word2.charAt(p)) {
                ans[idx++] = i;
                p++;
            } else if (!used && suf[i + 1] <= p + 1) {
                used = true;
                ans[idx++] = i;
                p++;
            }
        }

        return p == m ? ans : new int[0];
    }
}