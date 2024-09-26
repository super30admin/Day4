// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution2 {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        //only one element in the array
        if(nums.length==1)
            return nums[0];
        
        int low=0;
        int high=nums.length-1;
        //the array is sorted
        if(nums[low]<=nums[high])
            return nums[low];
        while(low<=high){
            int mid=low+(high-low)/2;
            //the subarray is sorted
            if(nums[low]<=nums[high]){
                return nums[low];
            }   
            if((mid==0||nums[mid-1]>nums[mid]) &&(mid==nums.length-1 || nums[mid+1]>nums[mid]))
                    return nums[mid];
            //left part is sorted so move to right
            else if(nums[low]<=nums[mid]){
                    low=mid+1;                
            }            
             else
                 high=mid-1;
        }
        return 678906;
        
    }
}