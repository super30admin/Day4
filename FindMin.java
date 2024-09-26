// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int lower = 0;
        int upper = nums.length-1;
        int mid = 0;

        //return default value if the the array is sorted or contains single element
        if(nums[lower]<=nums[upper])
            return nums[lower];

        //perform binary search
        while(lower<=upper){
            mid = lower + (upper-lower) / 2;

            //if num at mid is greater than the next, it is point of rotation and the next number should be min
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            //if num at mid is less than previous, the previous is point of rotation, and mid is min
            if(nums[mid] < nums[mid-1])
                return nums[mid];

            //update lower and upper as per logic for binary search
            if(nums[mid]>nums[lower])
                lower = mid+1;
                
            else
                upper = mid-1;
        }
        return -1;
    }
}