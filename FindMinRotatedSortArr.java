// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0];
            
        int low = 0;
        int high = nums.length-1;
        
        if(nums[low]<nums[high])
            return nums[low]; //As this means array is sorted without rotation
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid < high && nums[mid]>nums[mid+1]) //Handle arr out of bounds along with inflection point
                return nums[mid+1];
            if(low < mid && nums[mid] < nums[mid-1]) //Handle arr out of bounds along with inflection point
                return nums[mid];
            if(nums[mid]>nums[low]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}