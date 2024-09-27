// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understood from class


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{StartingPoint(nums,target), endpoint(nums,target)};
    }
    
    private int StartingPoint(int[] nums, int target){
        
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){return mid;}
                    high=mid-1;}
                else if(nums[mid]<target){low=mid+1;}
                else{high=mid-1;}
        }
            return -1;
}   
        private int endpoint(int[] nums, int target){  
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){return mid;}
                 low=mid+1;}
                else if(nums[mid]<target){low=mid+1;}
                else{high=mid-1;}
        }
            return -1;
}
        
}