package problem3;


// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Approach1 {

    public static void main(String[] args) {

        Approach1 obj = new Approach1();
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{1 , 2, 3};
        int[] nums = new int[]{1 , 2, 3, 2, 3, 4, 5, 3};
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // <= required for single element input [1]
        while (low <= high) {

            int mid = low + (high - low) / 2;

//            this mid == 0 & mid == n - 1 check is requried for condition nums = [1]
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
//            move left
            // mid > 0 required for single element input [1]
            else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            }
//            move right
            else {
                low = mid + 1;
            }

        }

        return 0;
    }

}
