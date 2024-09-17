// Time Complexity O(logn)
// Space Complexity O(1)
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            if(nums[start] <= nums[end]) return nums[start];
            
            int mid = start + (end - start) / 2;
            
            boolean leftgt = mid == 0 || nums[mid] > nums[mid-1];
            boolean rightgt = mid == nums.length - 1 || nums[mid] > nums[mid+1];
            
            if(leftgt && rightgt) {
                return nums[mid];
            }
            
            if(leftgt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            
        }
        
        return -1;
    }
}
