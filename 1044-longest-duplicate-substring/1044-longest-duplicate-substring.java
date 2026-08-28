import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int low = 1, high = n - 1;
        String ans = "";

        while (low <= high) {
            int len = (low + high) / 2;

            String dup = check(s, len);

            if (dup != null) {
                ans = dup;
                low = len + 1;
            } else {
                high = len - 1;
            }
        }

        return ans;
    }

    private String check(String s, int len) {
        long base = 26;
        long mod = 1000000007;

        long hash = 0;
        long power = 1;

        // First window hash
        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
            power = (power * base) % mod;
        }

        HashMap<Long, Integer> seen = new HashMap<>();
        seen.put(hash, 0);

        // Sliding window
        for (int i = len; i < s.length(); i++) {

            hash = (hash * base
                    - (s.charAt(i - len) - 'a') * power
                    + (s.charAt(i) - 'a')) % mod;

            if (hash < 0)
                hash += mod;

            int start = i - len + 1;

            if (seen.containsKey(hash)) {
                int oldStart = seen.get(hash);

                String oldString = s.substring(oldStart, oldStart + len);
                String newString = s.substring(start, start + len);

                if (oldString.equals(newString))
                    return newString;
            }

            seen.put(hash, start);
        }

        return null;
    }
}