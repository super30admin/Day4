// Time Complexity: Since we use binary search methods here, 
// so the time complexity will be O(logn).
/* --------------------------------------------------------*/
// Space Complexity: the space complexity will be O(1).
/* --------------------------------------------------------*/
// I am still confused about the how to consider the boundaries of these kinds 
// of problems, so that we will not miss any ones?

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    
}
