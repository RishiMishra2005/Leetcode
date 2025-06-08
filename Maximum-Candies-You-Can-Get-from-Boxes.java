class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[n];
        boolean[] hasBox = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (visited[box]) continue;

            visited[box] = true;
            totalCandies += candies[box];

            for (int key : keys[box]) {
                status[key] = 1;
                if (hasBox[key] && !visited[key]) {
                    queue.offer(key);
                }
            }

            for (int contained : containedBoxes[box]) {
                hasBox[contained] = true;
                if (status[contained] == 1 && !visited[contained]) {
                    queue.offer(contained);
                }
            }
        }

        return totalCandies;
    }
}