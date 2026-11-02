class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();
        int index = 0;
        for (int n : nums) {
            int diff = target - n;
            
            Integer prevIndex = prevMap.get(diff);
            if (prevIndex != null) {
                return new int[]{prevIndex, index};
            } 
            prevMap.put(n, index);
            index++;
        }
        return new int[]{};
    }
}
