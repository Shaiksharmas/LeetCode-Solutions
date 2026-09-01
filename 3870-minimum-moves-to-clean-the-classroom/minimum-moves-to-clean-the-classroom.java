import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, k = 0;

        int[][] id = new int[m][n];
        for (int[] row : id) Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = k++;
                }
            }
        }

        int target = (1 << k) - 1;
        if (target == 0) return 0;

        boolean[][][][] vis =
            new boolean[m][n][1 << k][energy + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0, energy, 0});
        vis[sr][sc][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0], c = cur[1];
            int mask = cur[2], e = cur[3], moves = cur[4];

            if (mask == target) return moves;
            if (e == 0) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int ne = e - 1;
                int nm = mask;
                char ch = classroom[nr].charAt(nc);

                if (ch == 'L') {
                    nm |= 1 << id[nr][nc];
                }

                if (ch == 'R') {
                    ne = energy;
                }

                if (!vis[nr][nc][nm][ne]) {
                    vis[nr][nc][nm][ne] = true;
                    q.offer(new int[]{nr, nc, nm, ne, moves + 1});
                }
            }
        }

        return -1;
    }
}