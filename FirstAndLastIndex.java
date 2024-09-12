class FirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(target < nums[0] || nums[nums.length - 1] < target) return new int[]{-1,-1};
        
        int left  =  BinarySearchLeft( nums, target, 0, nums.length - 1);
        int right =  BinarySearchRight( nums, target, left, nums.length - 1);
        return new int[]{left, right};
        
        }
    private int BinarySearchLeft(int[] nums, int target, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;
            
            if (nums[mid] == target){
                
                if (mid == 0 || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                } 
            }else if (nums[mid] > target ){
                high = mid - 1; 
            }else{
                low = mid + 1;
            }
            
        }
        return -1;
        
    }
    
    private int BinarySearchRight(int[] nums, int target, int low, int high){
        while (low <= high){
            int mid = low + (high - low)/2;
            
            if (nums[mid] == target){
                
                if (mid == nums.length -1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else {
                    low = mid + 1;
                } 
            }else if (nums[mid] < target ){
                low = mid + 1; 
            }else{
                high = mid - 1;
            }
            
        }
        return -1;
    }
}

