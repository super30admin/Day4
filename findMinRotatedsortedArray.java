class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low)/2;
        int min = nums[mid];
        while(low < high) {
            mid = low + (high - low)/2;  
            
            if(nums[mid] < nums[high]) {
                //sorted
                high = mid;
            }
            else {
                //unsorted
                low = mid + 1;
            }
        }
        
        return nums[high];
        
    }

}
