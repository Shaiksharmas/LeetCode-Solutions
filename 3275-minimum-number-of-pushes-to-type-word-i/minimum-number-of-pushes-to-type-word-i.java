class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;
        for(int i=25; i>=0; i--){
            if(freq[i]==0)break;
            ans += freq[i]*(idx/8+1);
            idx++;
        }
        return ans;
    }
}