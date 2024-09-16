TC:O(logn)
SC:O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 43.8 MB, less than 96.45% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Next challenges:




class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]= findFirstindex(nums,target);
        result[1]= findendindex(nums,target);
        return result;
    }
    
    
    
    
    public int findFirstindex(int[] nums, int target){
        int index=-1;
        int start = 0;
         int end =  nums.length-1;
        
        while(start<= end){
            int midpoint  = start+(end-start)/2;
            if(nums[midpoint] >= target) end = midpoint-1;
            else start= midpoint+1;
        
        if(nums[midpoint]== target) index = midpoint; 
        }
        return index;
        
    }

    public int findendindex(int[] nums, int target){
        int index=-1;
        int start = 0;
         int end =  nums.length-1;
        
        while(start<= end){
            int midpoint  = start+(end-start)/2;
            if(nums[midpoint] <= target) start = midpoint+1;
            else end= midpoint-1;
         if(nums[midpoint]== target) index = midpoint; 
        }
        return index;
        
    }
}
