class Solution {
    public int findMin(int[] nums) {
        //edge case
        if(nums.length == 1)
        {
            return nums[0];
        }        
        //binary search
        int n = nums.length-1;
        int low = 0;
        int high = nums.length-1;
        if(nums[high] > nums[low]) return nums[low];
        
        while(low<= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if(nums[mid]>nums[low] ){
                low = mid +1;
            } else {
                high = mid - 1;
            }
            
        }
        return -1;
    }
}
// Time Complexity: O(logN)
// Space Complexity: O(1)