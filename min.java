Time Complexity: O(log n)
Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low+(high-low)/2;
            
            if(nums[low] < nums[high])
                return nums[low];
            
            if((mid == nums.length - 1 || nums[mid] < nums[mid+1]) && (mid == 0 || nums[mid] < nums[mid-1]))
                return nums[mid];
            
            if(nums[low] <= nums[mid] && nums[mid] > nums[high]) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low];
    }
}