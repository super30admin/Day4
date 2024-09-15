// Time Complexity : O(log(N)) -> as binary search is involved
// Space Complexity : O(1) -> No extra space have been used
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
//I was unable to come up with a solution before class.

// Your code here along with comments explaining your approach


class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        
        if(nums.length == 1 || nums[0] < nums[nums.length-1])
            return nums[0];
        
        int low = 0;
        int high = nums.length -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(mid-1 >= 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            
            if(mid + 1 <= nums.length-1 && nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if(nums[low] <nums[mid]){
                low = mid + 1;
            }else{
                high = high -1;
            }
        }
        
        return -1;
    }
}