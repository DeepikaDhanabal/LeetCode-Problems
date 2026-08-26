class Solution {

    public String longestPalindrome(String s) {

        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            String odd = expandAroundCenter(s, i, i);

            // Even-length palindrome
            String even = expandAroundCenter(s, i, i + 1);

            // Pick the longer palindrome
            String currentLongest;

            if (odd.length() > even.length()) {
                currentLongest = odd;
            } else {
                currentLongest = even;
            }

            // Update longest
            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }
        }

        return longest;
    }

    // Expand from the center
    private String expandAroundCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}