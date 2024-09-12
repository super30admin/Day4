// Time Complexity - O(lg n)
// Space Complexity - O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums== null || nums.length==0){
            return -1;
        }
        
        int low = 0, high = nums.length - 1;
        
        while (low<=high) {
            
            int mid = low + (high-low)/2;
            if((mid == low || nums[mid]>nums[mid-1]) && (mid == high || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if (nums[mid]<nums[mid+1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
}
