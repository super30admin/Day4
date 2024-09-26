class FirstLastPosSortedArr {
    
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                int left = leftBinarySearch(nums, low, mid, target);
                int right = rightBinarySearch(nums, mid, high, target);
                return new int[]{left, right};
            }else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return new int[]{-1,-1};
        
    }
    
    private int leftBinarySearch(int[] nums, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else if(mid-1 >= 0 && nums[mid-1] < target)
                return mid;
            else
                high = mid - 1;     
        }
        return low;
    }
    
    private int rightBinarySearch(int[] nums, int low, int high, int target){
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target)
                high = mid - 1;
            else if(mid+1 < nums.length && nums[mid+1] > target)
                return mid;
            else
                low = mid + 1;
        }
        return high;
    }
}