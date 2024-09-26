// Time Complexity : O(log(n)) for finding the first and last index
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach


class Solution {
    int[] nums;
    int target; 
    
    private int binarySearch(boolean left){ // direction of binary search
        int start = 0;
        int end = nums.length-1;
        int pos = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target){
                pos = mid; // stores the latest index of target
                if(left){
                    end = mid-1; // finding the first index of target
                }else{
                    start = mid+1; //finding the last index of target
                }
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return pos;
    }
    
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int[] res = new int[]{-1,-1};
        
        if(nums.length==0)
            return res;
        if(nums.length-1==0 && nums[0] == target){
            res[0] = res[1] = 0;
            return res;
        }
        
        res[0] = binarySearch(true);
        if(res[0]==-1) //if first index is -1 then no need to check for last
            return res;
        res[1] = binarySearch(false);
        return res;
    }
}