// Time Complexity : O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        
        int left =0;
        int right = nums.length-1;
        
        if(nums[left]<nums[right]) return nums[0];
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid+1];
            }
            
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] < nums[left]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[0];
    }
}