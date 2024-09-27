// Time Complexity : O(log N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = getOccur(nums,target,true);
        
        if(first==-1)
            return new int[]{-1,-1};
        
        int last = getOccur(nums,target,false);
        
        return new int[]{first,last};
    }
    private int getOccur(int[] nums,int target, boolean isFirst){
        int begin =0;
        int end = nums.length-1;
        
        while(begin<=end){
            int mid = (begin+end)/2;
            
            if(nums[mid]==target){
                if(isFirst){
                    if(begin==mid||nums[mid-1]!=target )
                        return mid;
                    end=mid-1;
                }
                else{
                   if( end==mid || nums[mid+1]!=target)
                        return mid;
                    begin=mid+1;
                }
            }
            else if(nums[mid]>target)
                end=mid-1;
            else
                begin=mid+1;
        }
        return -1;
    }
}