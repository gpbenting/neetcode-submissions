class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> counter1 = frequencies(s);
        Map<Integer, Integer> counter2 = frequencies(t);
        return counter1.equals(counter2);
    }

    private Map<Integer, Integer> frequencies(String s) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int value = Character.getNumericValue(s.charAt(i));
            int frequency = frequencies.getOrDefault(value, 0);
            frequencies.put(value, ++frequency);
        }
        return frequencies;
    }
}
