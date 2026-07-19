import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}