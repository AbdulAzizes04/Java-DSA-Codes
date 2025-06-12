class Solution {
    private int start = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n; i++) {
            expandAround(s, i, i);
            expandAround(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }
    private void expandAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            if (len > maxLen) {
                start = left;
                maxLen = len;
            }
            left--;
            right++;
        }
    }
}
