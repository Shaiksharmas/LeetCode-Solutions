class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]); // here we are adding numbers to the hashset.
        }
        int longest = 0;

        Integer[] arr = set.toArray(new Integer[0]);

        for(int i=0; i<arr.length; i++){
            int num = arr[i];

            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                if(currentStreak > longest){
                longest = currentStreak;
                }
            }
        }
        return longest;
    }
}