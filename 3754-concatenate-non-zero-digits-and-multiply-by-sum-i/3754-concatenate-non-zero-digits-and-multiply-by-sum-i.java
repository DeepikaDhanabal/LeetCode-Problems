class Solution {
    public long sumAndMultiply(int n) {

        String s = "" + n;

        long x = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != '0') {
                int digit = ch - '0';
                x = x * 10 + digit;
                sum = sum + digit;
            }
        }

        return x * sum;
    }
}