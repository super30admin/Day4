package problem3;


// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Approach2 {

    public static void main(String[] args) {

        Approach2 obj = new Approach2();
        int[] nums = new int[]{1};
//        int[] nums = new int[]{1 , 2, 3};
//        int[] nums = new int[]{1 , 2, 3, 2, 3, 4, 5, 3};
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
