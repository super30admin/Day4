// Time complexity = O(logn)
//Space = O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length-1;
        int i = first(nums, target, 0, n);
        int j = second(nums, target, 0, n);
        return new int[] {i,j};
        
        
    }
    public int first(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end-start) / 2;
            
            if(target == nums[mid]){
            if(mid == start || nums[mid - 1] < nums[mid]){
                return mid;
            }
            else{end = mid - 1;}
        }
        else if(target < nums[mid]){
            end = mid - 1;
        }
        else{
            start = mid + 1;
            
            
        }
    }
        return -1;
}
    public int second(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(target == nums[mid]){
            if(mid == end || nums[mid + 1] > target){
                return mid;
            } 
            else{start = mid + 1;}
        }
        else if(target > nums[mid]){
            start = mid + 1;
        }
        else{
            end = mid - 1;
        }
    }
        return -1;
      
        
    }
}