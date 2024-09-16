class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        
        int f = findFirst(nums, target);
        int l = -1;
        
        if(f != -1){
            l = findLast(nums, target, f);
        }
        
        return new int[]{f,l};
        
        
    }
    
    int findFirst(int[] nums, int target){
        int high = nums.length-1;
        int low = 0;
        
        
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                if(mid > 0 && nums[mid-1] == target)
                    high = mid - 1;
                else
                    return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
    int findLast(int[] nums, int target, int low){
        
        int high = nums.length - 1;
       
        
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                if(mid < nums.length-1 && nums[mid+1] == target)
                    low = mid + 1;
                else
                    return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
    
}