class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(char ch : columnTitle.toCharArray()){
            result = result * 26+(ch-'A'+1);
        }
        return result;
    }
}