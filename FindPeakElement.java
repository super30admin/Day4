// Time Complexity : O(log n)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not understand how it is dealing with comparison to its previous element

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end-start) / 2;
            
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }
            else {
                start = mid+1;
            }
            
        }
        return start;
        
    }
}