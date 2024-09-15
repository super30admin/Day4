class FindMinimum {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if(nums[low] <= nums[mid]) { // left half is sorted
                
                low = mid + 1;
            } else { //right half is sorted
                
                high = mid - 1;
            }
        }
        return -1;
    }
} 