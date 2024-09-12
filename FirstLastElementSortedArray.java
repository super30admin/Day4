class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = getFirstElement(nums, target, 0, nums.length - 1);
        int l = getLastElement(nums, target, 0, nums.length - 1);
        
        return new int[] {f, l};
    }
    
    public int getFirstElement(int[] nums, int target, int start, int end){
         while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }
                else{
                    end = mid - 1;
                }
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public int getLastElement(int[] nums, int target, int start, int end){
         while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid+1] > target){
                    return mid;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
