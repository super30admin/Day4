// Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : minimizing the else if condition 
        // from ==> (mid ==0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])
        // to  ==> mid > l && nums[mid] > nums[mid+1]

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if((mid == l || nums[mid-1] < nums[mid]) && (mid == r || nums[mid] > nums[mid+1])) return mid;
            else if(mid > l && nums[mid] > nums[mid+1]){
                r =mid -1;
            }else{
                l=mid+1;
            }
        }
        
        return -1;
    
    }
}