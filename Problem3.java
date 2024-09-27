//Problem 3: (https://leetcode.com/problems/find-peak-element/)
//Space complexity : O(1)
//Time complexity : O(logn)
class Problem3 {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (high == 0)
            return 0;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }
}