/*******
## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Time Complexity :   O (log n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (153. Find Minimum in Rotated Sorted Array)
Any problem you faced while coding this :       No
*******/

class FindMin {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        // binary search
        if (nums[0] < nums[nums.length -1]){
            return nums[0];
        }

        // binary search
        while (low + 1 < high){
            int mid = low + (high - low) / 2;

            // nums nums[mid] < right, look into left part
            if (nums[mid] < nums[high]){
                high = mid;
            }
            // else look into right part
            else{
                low = mid;
            }
        }
        return nums[high];
    }

    public static void main(String args[]) 
    { 
        FindMin obj = new FindMin();
        int[] nums = {4,6,8,9,10,2};
        System.out.println("Min Element: " + obj.findMin(nums));
    }
}
