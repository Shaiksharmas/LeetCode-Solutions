class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);

        int pushes = 0;
        int cost = 1;
        int count = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            pushes += freq[i] * cost;
            count++;

            if (count == 8) {
                cost++;
                count = 0;
            }
        }

        return pushes;
    }
}