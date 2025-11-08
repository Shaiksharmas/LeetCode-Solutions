class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, used, temp,ans);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}