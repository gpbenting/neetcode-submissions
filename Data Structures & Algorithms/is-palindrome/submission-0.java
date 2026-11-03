class Solution {
    public boolean isPalindrome(String s) {
        String original = clean(s);
        return new StringBuilder(original).reverse().toString().equals(original);
    }

    private String clean(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        }
        return result.toString().toLowerCase();
    }
}
