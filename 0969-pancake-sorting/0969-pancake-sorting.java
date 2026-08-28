class Solution {
    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> result = new ArrayList<>();

        for (int curr = arr.length; curr > 1; curr--) {

            int maxIndex = 0;
            for (int i = 1; i < curr; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (maxIndex != 0) {
                reverse(arr, maxIndex + 1);
                result.add(maxIndex + 1);
            }

            reverse(arr, curr);
            result.add(curr);
        }

        return result;
    }

    private void reverse(int[] arr, int k) {

        int left = 0;
        int right = k - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}