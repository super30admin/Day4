class Solution {
    //Time complexity : O(logn)
    //Space complexity : O(1)
    public int[] searchRange(int[] nums, int target) {
        int first = BinarySearchFirst(nums, target);
        int last = BinarySearchLast(nums, target);
         
        return new int[]{first,last};
        
    }
    
    private int BinarySearchFirst(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }
                else high = mid-1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else low = mid + 1;
        }
        return -1;
    }
        
         private int BinarySearchLast(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }
                else low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else low = mid + 1;
        }
             return -1;
    }
}