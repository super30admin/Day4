// Time Complexity: O(N);
// Space Complexity: O(1);
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length -1 || nums[mid+1] < nums[mid] ))){
                return mid;
            } else if (mid>0 && nums[mid-1] > nums[mid]){
                high = mid -1;
            } else if (nums[mid+1] > nums[mid]){
                low =mid +1;
            }
        }
        return -1;
    }
}