class Solution {
    public int repeatedStringMatch(String a, String b) {

        String repeated = "";
        int count = 0;

        while (repeated.length() < b.length()) {
            repeated = repeated + a;
            count++;
        }

        if (repeated.contains(b)) {
            return count;
        }

        repeated = repeated + a;
        count++;

        if (repeated.contains(b)) {
            return count;
        }

        return -1;
    }
}