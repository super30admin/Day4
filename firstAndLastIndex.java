//time complexity: O(log n)
//space complexity:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//if we fing target then for sure start<=mid and mid<end
// so we can apply binary search to find start and end on the left and right arrays
// to find start -> when you reach an element where mid = targte and mid!=target then we have found start
// similarly, when we find mid = target and mid+1 != target, then we have found end

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = getStartIndex(nums, target);
        int end = getEndIndex(nums,target, start);
        
        return new int[]{start,end}; 
    }
    
    //get left most index of target
    private int getStartIndex(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        
        while(l<=r) {
            int mid = l + (r-l)/2;
            //check if mid is start
            if(nums[mid] == target) {
                //if target is at 0 index or if the prev item is not target
                //return mid
                if(mid==0 || nums[mid-1] !=target)
                    return mid;
                else // else we have hit somewhere in between the seq of target
                    r = mid-1; //reduce search space to l, mid-1
            } else if(target < nums[mid]) {
                //if target less than mid, then start is in the first half of array
                r = mid-1;
            } else {
                //targt should be in the second half
                l=mid+1;
            }
        }
        return -1;
    }
    
    //get right most index of target
    private int getEndIndex(int[] nums, int target, int start) {
        
        //if start is -1 then target doesn't exist
        if(start == -1) {
            return -1;
        }
        
        int l = start;
        int r = nums.length -1;
        
        while(l<=r) {
            int mid = l + (r-l)/2;
            
            if(nums[mid] == target) {
                //check if mid is end, or the next item is not target
                //return mid
                if(mid==nums.length-1 || nums[mid+1] !=target)
                    return mid;
                else //target is in the right array
                    l = mid+1; //reduce search space to mid+1, r
            } else if(target < nums[mid]) {
                //target is in the first half
                //reduce search space to l, mid-1
                r = mid-1;
            } else {
                //target is in the 2nd half, reduce search space to mid+1, r
                l=mid+1;
            }
        }
        return -1;
    }
}