/* Time complexity: O(logn)
Space complexity: O(n)
1. carry out binary search
2. strategy is to check if the prev and next elemenets of mid element is greater and smaller respectively.
3. continue the step-2 in non-increasing sub-sequence until we find the desired lowest element. */



class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[low] < nums[high]){
                return nums[low];
            }
            if((mid == low || nums[mid-1] > nums[mid]) && (mid == high || nums[mid+1] < nums[mid]))
            {
                return nums[mid];
            }
            else if(nums[low] <=nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;        
    }
}