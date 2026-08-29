public class Solution {

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        backtrack(0, digits, phone, path, result);

        return result;
    }

    private void backtrack(
        int index,
        String digits,
        String[] phone,
        StringBuilder path,
        List<String> result
    ) {

        // Base case
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {

            path.append(letter);

            backtrack(index + 1, digits, phone, path, result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}