class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            pq.add(stone);
        }

        // Smash two heaviest stones
        while (pq.size() > 1) {

            int y = pq.poll();  // heaviest
            int x = pq.poll();  // second heaviest

            if (x != y) {
                pq.add(y - x);
            }
        }

        // If no stone, return 0
        if (pq.isEmpty()) {
            return 0;
        }

        return pq.peek();
    }
}