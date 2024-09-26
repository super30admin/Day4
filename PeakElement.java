class PeakElement {
    
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid+1 < nums.length && nums[mid] < nums[mid+1])
                low = mid + 1;
            else if(mid-1 >= 0 && nums[mid-1] > nums[mid])
                high = mid - 1;
            else
                return mid;
        }
        
        return -1;
    }
}