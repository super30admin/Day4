
// Time Complexity : Add : O(log (n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;

        while(left<right){
            int midpoint = left + (right - left)/2;
            if(nums[midpoint]<nums[midpoint+1])
                left = midpoint + 1;
            else
                right = midpoint;
        }

        return left;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        findPeakElement(nums);
    }
}
