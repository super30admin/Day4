//Time complexity: O(log(n))
//Space Complexity: O(1)
//Notes: Performing binary search twice, to find the first and last position of the number. 
//To find the first position, iterate till [mid] < [mid-1] or mid == low i.e. min position of target is at start of the sub-array

class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        
        int[] output = new int[]{-1,-1};
        
        if(nums == null || nums.length == 0) return output;

        int ind1 = firstBinarySearch(nums, target);
        int ind2 = secondBinarySearch(nums, target);
        
        output[0] = ind1;
        output[1] = ind2;
        
        return output;
    }
    
    public int firstBinarySearch(int[] nums, int target){
                
        int low = 0;
        int high = nums.length - 1 ;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target ){
                if((mid == low || nums[mid-1] < nums[mid]))
                    return mid;
                else 
                    high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int secondBinarySearch(int[] nums, int target){
        
        int low = 0;
        int high = nums.length - 1 ;
               
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target ){
                if(mid == high || nums[mid+1] > nums[mid])
                    return mid;
                else 
                    low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
}