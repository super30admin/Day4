// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution3 {
    public int findPeakElement(int[] nums) {
        if(nums==null ||nums.length==0)
            return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            //if peak is on the first or last index
            if((mid==0||nums[mid]>nums[mid-1]) &&( mid==nums.length-1 || nums[mid]>nums[mid+1]))
                return mid;
            //  move towards the element with larger value
            else if(nums[mid+1]>nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }
       return 6789; 
    }
}