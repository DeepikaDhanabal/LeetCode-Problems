class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String ref = strs[0];

        for (int charIndex = 0; charIndex < ref.length(); charIndex++) {

            char currChar = ref.charAt(charIndex);

            for (int i = 1; i < strs.length; i++) {

                String word = strs[i];

                if (charIndex == word.length() ||
                    word.charAt(charIndex) != currChar) {

                    return ref.substring(0, charIndex);
                }
            }
        }

        return ref;
    }
}