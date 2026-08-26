class Solution {
    public static void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int index = 0;
        while (zero > 0) {
            nums[index] = 0;
            index++;
            zero--;
        }
        while (one > 0) {
            nums[index] = 1;
            index++;
            one--;
        }
        while (two > 0) {
            nums[index] = 2;
            index++;
            two--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}  
    
