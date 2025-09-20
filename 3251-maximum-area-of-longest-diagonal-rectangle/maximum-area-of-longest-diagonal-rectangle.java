class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;
        for (int[] dim : dimensions) {
            int w = dim[0], h = dim[1];
            double diagonal = Math.sqrt((long)w * w + (long)h * h);
            int area = w * h;
            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal;
                maxArea = area;
            }
        }
        return maxArea;
    }
}