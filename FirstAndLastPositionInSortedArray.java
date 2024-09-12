class FirstAndLastPositionInSortedArray{
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        //Target is not in the array <low and >high
        if(target < nums[0] || target > nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        
        int firstOccurance = findFirstOccurance(nums, target);
        int lastOccurance = findLastOccurance(nums, target);
        
        return new int[]{firstOccurance, lastOccurance};
    }
    
    private int findFirstOccurance(int[] nums, int target){
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid-1;   
                } 
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return -1;
    }
    
    private int findLastOccurance(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(target == nums[mid]){
                if(mid == nums.length-1 || nums[mid+1] > nums[mid]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}