class Solution {
    public String reversePrefix(String word, char ch) {
    int index = word.indexOf(ch);
    if(index == -1){
        return word;
    } 
    String part1 = word.substring(0, index + 1);
    String reverse = "";
    for(int i = part1.length()-1; i>=0; i--){
        reverse = reverse + part1.charAt(i);
    }
    String part2 = word.substring(index + 1);
    return reverse + part2;
    }
}