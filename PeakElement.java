
// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, need to study more on how to deal with edge cases. 
class Solution {

    public int findPeakElement(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length;
        
        while(low <= high) {
            int mid = (low+high)/2;
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) && (mid == 0 ||nums[mid] > nums[mid-1])){
                return mid;
            }else if(mid > 0 && nums[mid] < nums[mid-1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return -1;
    }
}