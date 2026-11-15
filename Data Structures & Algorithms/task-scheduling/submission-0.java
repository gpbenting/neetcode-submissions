class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t: tasks) {
            count[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int c: count) {
            if (c > 0) {
                maxHeap.offer(c);
            }
        }

        int time = 0;
        Queue<CoolDownItem> cooldown = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldown.offer(new CoolDownItem(remaining, time + n));
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek().time() == time) {
                maxHeap.offer(cooldown.poll().remaining());
            }
        }

        return time;
    }

    private record CoolDownItem(int remaining, int time) { }
}
