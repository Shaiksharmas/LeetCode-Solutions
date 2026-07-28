class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = '\0';

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                mid = (char) (i + 'a');
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != '\0') {
            ans.append(mid);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}