class Solution1 {
    public int[] searchRange(int[] nums, int target) {
    
        int left = leftMost(nums,target);
        
        if(left== -1){
            return new int[]{-1,-1};
        }
        int right = rightMost(nums,target);
        
        return new int[]{left,right};
    }
    
    private int leftMost(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target){
                if(mid==low || nums[mid-1]!= target){
                    return mid;
                }
                high = mid-1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    private int rightMost(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid]==target){
                if(mid==high || nums[mid+1]!= target){
                    return mid;
                }
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}