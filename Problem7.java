class Solution {
    // this function is used to find the first occurance of the target element.
    public int first(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                // this is the condition where we identify the first occurance of the larget element.
                if(mid==low||nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high=mid-1;
                }
            // regular binary search.
            }else if(nums[mid]>target){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;
    }
    
    //this function is used to find the last occurance of the target element. 
    public int last (int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                // this is the condition where we identify the last occurance of target element.
                if(mid==high||nums[mid]<nums[mid+1]){
                    return mid;
                }else{
                    low=mid+1;
                }
            // regular binary search.
            }else if(nums[mid]>target){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        
        int left= first(nums,0,nums.length-1,target);
        int right= last(nums,0,nums.length-1,target);
        
        return new int[]{left,right};
        
    }
}
