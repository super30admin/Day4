// T.C = O(logn)
// S.C = O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};  //if no element present
        if(target<nums[0] || target>nums[nums.length-1]) return new int[] {-1,-1};  //if element is not in array
        
        int first = binarySearchfirst(nums,target);
        if(first == -1) return new int[] {-1,-1};       
        int last = binarySearchlast(nums,target);
        
        return new int[] {first,last};   
    }
    
    private int binarySearchfirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    return mid;
                    }
                else{
                high = mid-1;
                }
            }
                
            else if(target<nums[mid]){
                    high = mid-1;
                }
            else{
                    low = mid+1;
                }
            }
        return -1;
    }
    
       private int binarySearchlast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == nums[mid]){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                    }
                else{
                low = mid+1;
                }
            }
                
            else if(target<nums[mid]){
                    high = mid-1;
                }
            else{
                    low = mid+1;
                }
            }
        return -1;
    }
}
