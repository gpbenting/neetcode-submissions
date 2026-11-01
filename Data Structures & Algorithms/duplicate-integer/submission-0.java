class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int n: nums) {
            if (!numbers.add(n)) {
                return true;
            }
        }
        return false;
    }
}