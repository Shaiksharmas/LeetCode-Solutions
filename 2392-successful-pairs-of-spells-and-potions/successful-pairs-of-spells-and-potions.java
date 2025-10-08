class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); 
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long required = (success + spell - 1) / spell;
            int idx = firstPotionIndex(potions, required);
            res[i] = m - idx;
        }

        return res;
    }
    private int firstPotionIndex(int[] potions, long required) {
        int left = 0, right = potions.length - 1, ans = potions.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= required) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}