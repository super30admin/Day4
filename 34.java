// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : taken algorithm from youtube
//



// Your code here along with comments explaining your approach
//used modified binary search twice for start index and end index. for first index, when element is found at mid go to left ... and go to right for last index

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start=0;
        int end=nums.length-1;
        int ans[]={-1,-1};
        
        while(start<=end){
           int mid=((end-start)/2)+start;
            
            if(nums[mid]==target){
                ans[0]=mid;
                end=mid-1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }
        }
        
         
        int start1=0;
        int end1=nums.length-1;
        
        while(start1<=end1){
           int mid1=((end1-start1)/2)+start1;
            
            if(nums[mid1]==target){
                ans[1]=mid1;
                start1=mid1+1;
            }else if(target<nums[mid1]){
                end1=mid1-1;
            }else if(target>nums[mid1]){
                start1=mid1+1;
            }
        }
        return ans;
    }
}