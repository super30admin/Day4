// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int[] searchRange(int[] nums, int target) {
    
        int startPos = bs(nums, target, true);

        int endPos = bs(nums, target, false);
        
        return new int[]{startPos, endPos};

    } 
    private int bs(int[] nums, int target, boolean startFlag){
        int start = 0, end = nums.length-1;

        while(start <= end){
                
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                    
                if(startFlag)
                {
                    if(mid == 0 || nums[mid-1] != target){
                        return mid;
                    }                    
                    
                    end  = mid - 1;
                }
                else{
                    if(mid == nums.length-1 || nums[mid+1] != target)
                    {
                        return mid;        
                    }
                    start = mid + 1;
                }
            }

            else if(target < nums[mid]){
                end = mid -1;
            }
            else
            {
                start = mid +1;
            }
        }
        return -1;
    }

}