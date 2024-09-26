// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        // check for empty array
        if(nums==null || nums.length==0)
            return new int []{-1,-1};
        // find first occurrenece
        int left=Bleft(nums,target);
        //if element not found at all
        if(left==-1)
            return new int []{-1,-1};
        //find last occurrence
        int right=Bright(nums,target,left);
        
        return new int[]{left,right};
        
    }
    
    public int Bleft(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
    //if mid is first index or we have moved to extreme left occurenec of the target
                if(mid==0||nums[mid-1]!=target)
                    return mid;
                else if(nums[mid-1]==target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else
                low=mid+1; 
        }
        return -1;
    }
    
    public int Bright(int[] nums, int target, int left){
        int low=left;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                //if mid is last index or we have moved to extreme right occurenec of the target
                if(mid==nums.length-1 || nums[mid+1]!=target)
                    return mid;
                else if(nums[mid+1]==target)
                    low=mid+1;
                else
                    high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else
                low=mid+1; 
        }
        return -1;
    }
}