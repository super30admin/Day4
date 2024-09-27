
// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// we can use 2 binary search here. first to find the starting index of given target value and 2nd to find the ending index of the target value. To 
// optimize it, we can use the starting index from the first binary search for the 2nd binary search.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums,0,nums.length-1,target);
        if(first == -1)
            return new int[] {-1,-1};
        int last = binarySearchLast(nums,first,nums.length-1,target);
        
        return new int[] {first,last};
    }
    
    public int binarySearchFirst(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target){
                if(mid == 0 || nums[mid-1] < target)
                    return mid;
                else
                    end = mid-1;
             }
            else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    
    public int binarySearchLast(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid+1] > target)
                    return mid;
                else
                    start = mid+1;
             }
           else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
