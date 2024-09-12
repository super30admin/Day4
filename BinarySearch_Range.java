// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[]{-1,-1};
        if(nums.length<=0){
            return result;
        }
        int start = 0;
        int end = nums.length -1;
        result[0] = searchIndex(nums,start,end,target,false);
        if(result[0]!=-1){
            result[1] = searchIndex(nums,start,end,target,true);
        }
        return result;
    }
    
    private int searchIndex(int[] nums, int start, int end, int target, boolean findIndex){
        int position = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }
            else if(target<nums[mid]){
                end=mid-1;
            }
            else{
                position = mid;
                if(findIndex){
                    start = mid+1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        return position;         
    }
}