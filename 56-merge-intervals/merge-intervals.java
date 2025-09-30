class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (merged.size() == 0) {
                merged.add(intervals[i]);
            } else {
                int[] last = merged.get(merged.size() - 1);
                if (last[1] >= intervals[i][0]) {
                    last[1] = Math.max(last[1], intervals[i][1]);
                } else {
                    merged.add(intervals[i]);
                }
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}