// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, checking mid based on high was the issue which got cleared after class


// Your code here along with comments explaining your approach

class Solution {
    //TC: O(logn)
    //Sc: O(1)
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            //At any point, if mid is les than previous element and less than next element , we return that
            //Exceptions here are if mid=0 then we check only the next element, also same holds for last element
            if((mid==0||nums[mid]<nums[mid-1]) && (mid==nums.length-1||nums[mid]<nums[mid+1]))            {
                return nums[mid];
            }
            else{
                if(nums[mid]>nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
