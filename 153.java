// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : taken algorithm from youtube
//



// Your code here along with comments explaining your approach
//used modified binary search 

class Solution {
    public int findMin(int[] nums) {
    
        
         int start=0;
        int end=nums.length-1;
        
        while(start<end){
           int mid=((end-start)/2)+start;
            
            if(nums[mid]>nums[end]){
                
                start=mid+1;
            }else
                end=mid;
            }
        return nums[end];
        }
    }