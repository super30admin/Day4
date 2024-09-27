// Time Complexity: O(log n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No (Not sure about space complexity)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        Arrays.fill(result, -1);
        
        if(nums==null || nums.length ==0) return result;
        
        result[0]= search(nums,target,true);
        result[1]= search(nums,target,false);
        
        return result;
        
    }    
            
        int search(int[] nums, int target, boolean isFirst){
            int low=0, high = nums.length -1,mid=0;
            int index = -1;
            while(low<=high){
                mid = low + (high-low)/2;

                if(nums[mid]==target){
                    // first index
                    if(isFirst){
                    index= mid;
                    high = mid - 1;
                    }
                    
                    //last index
                    else{
                    index= mid;
                    low = mid + 1;
                    }
                }
                else if(nums[mid]> target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
        }
              return index;
        }
      

}