// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Check boundary condition for low element if not then do binarySearch
class MinimumRotatedSortArray {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) 
            return -1;
        int low=0,high=nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[low]<nums[high]) return nums[low];
            // Check boundary elements
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            } else if(nums[low]<nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;               
            }
        }
        return -1;
    }
        
}
