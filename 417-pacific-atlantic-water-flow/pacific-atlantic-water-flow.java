class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacQueue.offer(new int[]{0, j});
            atlQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }
        bfs(heights, pacific, pacQueue);
        bfs(heights, atlantic, atlQueue);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int m = heights.length, n = heights[0].length;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < heights[r][c]) continue; 
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}