// S30 Big N Problem #9 {Medium}
// 162. Find Peak Element
// Time Complexity :O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
//  l     m     h
// [1 2 1 3 5 6 4]
// case 1 - mid>mid-1 && mid>mid+1 return mid
// case 2 - if not check mid+1
// if mid+1>mid - make a binary search on right side
// else make a binary search on left side
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((low==mid || nums[mid]>nums[mid-1]) && (high==mid || nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid+1]>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}