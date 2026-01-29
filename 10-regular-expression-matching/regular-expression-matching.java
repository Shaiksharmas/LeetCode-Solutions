class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] match = new boolean[sLen + 1][pLen + 1];

        match[0][0] = true;
        for (int j = 2; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                match[0][j] = match[0][j - 2];
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {

                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '.' || pChar == sChar) {
                    match[i][j] = match[i - 1][j - 1];
                }
                else if (pChar == '*') {
                    match[i][j] = match[i][j - 2];
                    char prevPatternChar = p.charAt(j - 2);
                    if (prevPatternChar == '.' || prevPatternChar == sChar) {
                        match[i][j] = match[i][j] || match[i - 1][j];
                    }
                }
            }
        }

        return match[sLen][pLen];
    }
}