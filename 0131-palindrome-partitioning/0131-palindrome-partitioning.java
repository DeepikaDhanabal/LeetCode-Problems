class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        List<String> current,
        List<List<String>> result
    ) {

        // Base condition
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            String part = s.substring(start, end + 1);

            // Only choose palindrome
            if (isPalindrome(part)) {

                current.add(part);

                backtrack(s, end + 1, current, result);

                // Undo
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}