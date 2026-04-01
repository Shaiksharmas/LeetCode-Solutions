class Solution {public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && robot[1] > 0) {
                    int[] top = stack.peek();
                    if (top[1] < robot[1]) {
                        stack.pop();
                        robot[1]--;
                    } else if (top[1] > robot[1]) {
                        top[1]--;
                        robot[1] = 0;
                    } else {
                        stack.pop();
                        robot[1] = 0;
                    }
                }
                if (robot[1] > 0) {
                    stack.push(robot);
                }
            }
        }
        List<int[]> survivors = new ArrayList<>(stack);
        Collections.sort(survivors, (a, b) -> a[3] - b[3]);

        List<Integer> result = new ArrayList<>();
        for (int[] r : survivors) {
            result.add(r[1]);
        }
        return result;
    }
}