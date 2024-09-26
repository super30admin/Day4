class TwoSolution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        return findMin(nums, 0, nums.length-1);
    }
    
    public int findMin(int[] nums, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }            

            if(nums[mid] > nums[0]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }                
        }        
        return -1;
    }
}
