//Find Minimum in rotated sorted array


// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Problem2 {
    public int findMin(int[] nums) {
        //In a rotated sorted array, minimum will be in unsorted side

        if(nums.length == 0 || nums == null)
            return -1;

        int low =0;
        int high=nums.length-1;
        int mid;

        while(low<=high){

            if(nums[low] < nums[high])
                return nums[low];

            mid = low + (high -low) / 2;

            //Base case
            if((mid == 0 || nums[mid] < nums[mid-1]) && ( mid ==nums.length-1 || nums[mid] < nums[mid+1] )){
                return nums[mid];
            }

            //Go towards the unsorted side
            if(nums[low] <= nums[mid])
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;


    }
}