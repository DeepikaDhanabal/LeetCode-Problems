class Solution {
    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';
            int width = widths[index];

            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } 
            else {
                currentWidth += width;
            }
        }

        return new int[]{lines, currentWidth};
    }
}