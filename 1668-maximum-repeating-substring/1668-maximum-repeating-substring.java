class Solution {
    public int maxRepeating(String sequence, String word) {
        
        String current = "";
        int count = 0;

        while (sequence.contains(current + word)) {
            current = current + word;
            count++;
        }

        return count;
    }
}