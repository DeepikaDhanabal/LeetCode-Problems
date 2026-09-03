class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0, "");
        return result;
    }

    void backtrack(String s, int index, int parts, String current) {

        // 4 parts created
        if (parts == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        // Try 1, 2, and 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }

            // Value should be <= 255
            if (Integer.parseInt(part) > 255) {
                continue;
            }

            backtrack(
                s,
                index + len,
                parts + 1,
                current + part + "."
            );
        }
    }
}

