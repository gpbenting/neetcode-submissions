class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> freqs = frequencies(str);
            List<String> group = groupMap.getOrDefault(freqs, new ArrayList<>());
            group.add(str);
            groupMap.put(freqs, group);
        }

        return groupMap.values().stream().toList();
    }

    private Map<Character, Integer> frequencies(String str) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (Character ch: str.toCharArray()) {
            int count = freqs.getOrDefault(ch, 0);
            freqs.put(ch, ++count);
        }
        return freqs;
    }
}
