/*
Algorithm:
    1. If mid element is greater than its neighbors then return the mid element.
    2. If the rightside of the mid element is greater than the mid element, then update the low pointer to mid+1.
    3. Else move to the left by high = mid-1.
    
    Time Complexity: O(logn)
    Space Complexity: O(1)
    
    Did the code run successfully on leetcode?: Yes

*/


class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if((low==mid || nums[mid-1]<nums[mid]) && (high==mid || nums[mid+1] <nums[mid]))
                return mid;
            else if(nums[mid]<=nums[mid+1])
                low = mid+1;
            else
                high = mid-1;
            
        }
        
        return -1;
        
    }
}