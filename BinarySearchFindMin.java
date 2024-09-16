// Time Complexity : O(Log(N))
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach

class BinarySearchFindMin {
    
   public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] < nums[high]){return nums[low];}
            if((mid == high || nums[mid] < nums[mid+1]) && (mid == low || nums[mid] < nums[mid-1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}