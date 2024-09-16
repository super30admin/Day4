// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes

class Solution {
    public int findPeakElement(int[] nums) {
        int left =0;
        int right =nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            
            //check if mid is first/last element then check if its greater than its neighbours
            if((mid==0 || nums[mid]>nums[mid-1])&&(mid==nums.length-1||nums[mid]>nums[mid+1])){
                return mid;
            }
            
            
            //if u check mid with left element check the edge case that its not the first element
            //if left is greater then move right boundry to mid+1
            else if(mid>0 && nums[mid]<nums[mid-1]){
                right=mid-1;
            }
            
            //else move the lower boundry
            else{
                left = mid+1;
            }
        }
        
        return -1;
    }
}