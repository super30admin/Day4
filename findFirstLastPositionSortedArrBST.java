//TC: O(log n)
//SC: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeftIndex(nums, target);
        result[1] = findRightIndex(nums, target);
        return result;
    
    }
    
    public int findLeftIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){ 
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                index = mid;
            }
            
            if(nums[mid] >= target ){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return index;
    }
    
     public int findRightIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
            
            while(start <= end){
                int mid = start + (end - start)/2;
                 if(nums[mid] == target) {
                index = mid;
            }
                
                if(nums[mid] <= target ){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
            
            
        return index;
    }
    
}