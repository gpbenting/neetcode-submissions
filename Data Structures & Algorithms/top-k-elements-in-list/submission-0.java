class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = frequencies(nums);
        return frequencyMap.entrySet().stream()
                .map(entry -> new Frequency(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(Frequency::count).reversed())
                .toList().subList(0, k)
                .stream()
                .mapToInt(Frequency::value).toArray();
    }

    private record Frequency(int value, int count) { }

    private Map<Integer, Integer> frequencies(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int n : nums) {
            Integer count = result.getOrDefault(n, 0);
            result.put(n, ++count);
        }
        return result;
    }
}
