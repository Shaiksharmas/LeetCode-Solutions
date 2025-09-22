import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
      
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
      
        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }
        
        int total = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                total += f;
            }
        }
        
        return total;
    }
}