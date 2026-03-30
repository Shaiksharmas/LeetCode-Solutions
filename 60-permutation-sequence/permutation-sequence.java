class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--; 
        StringBuilder result = new StringBuilder();
        
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact[i - 1];
        }
        
        return result.toString();
    }
}