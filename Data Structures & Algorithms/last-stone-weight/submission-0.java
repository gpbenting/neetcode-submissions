class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : stones) {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1) {
            int remainingWeight = maxHeap.poll() - maxHeap.poll();
            if (remainingWeight > 0) {
                maxHeap.offer(remainingWeight);
            }
        }

        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }
}
