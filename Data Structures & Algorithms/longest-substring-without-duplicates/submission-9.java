class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder substring = new StringBuilder();
        int result = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            
            if (substring.toString().contains(ch + "")) {
                result = Math.max(result, substring.length());
                substring.delete(0, substring.lastIndexOf(ch + "") + 1);
            }
        
            substring.append(ch);
        }
        return Math.max(result, substring.length());
    }
}
