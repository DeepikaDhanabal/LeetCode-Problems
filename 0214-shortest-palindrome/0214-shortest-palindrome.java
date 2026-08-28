class Solution {
    public String shortestPalindrome(String s) {

        int n = s.length();

        String rev = "";
        int i = n - 1;

        while (i >= 0) {
            rev += s.charAt(i);
            i--;
        }

        String temp = s + "#" + rev;

        int[] lps = new int[temp.length()];

        int j = 0;
        i = 1;

        while (i < temp.length()) {

            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = lps[j - 1];
            }

            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }

            lps[i] = j;
            i++;
        }

        int longest = lps[temp.length() - 1];

        String ans = "";
        i = 0;

        while (i < n - longest) {
            ans += rev.charAt(i);
            i++;
        }

        return ans + s;
    }
}