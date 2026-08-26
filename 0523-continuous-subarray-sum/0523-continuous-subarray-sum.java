class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {

                int previousIndex = map.get(remainder);

                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }
}