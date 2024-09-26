// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The approach over here is to use the binary search to find the mid of the array,
//then check which side is non sorted and update the low or high accordingly.
//In case if we have already sorted array we return the value at low

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;

        int low = 0, high = nums.length-1;

        while(low<=high){
            //if sorted array
            if(nums[low]<nums[high]) return nums[low];

            int mid = low + (high-low)/2;
            //mid is less than its neighbours
            if((mid == 0 || nums[mid]<nums[mid-1]) &&
                    (mid == nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else{
                //check if left side is unsorted
                if(nums[low]>nums[mid]){
                    high = mid-1;
                }
                else {
                    //right side is unsorted
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
