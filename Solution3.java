// Time Complexity : O(logn) where n is the number of elements in nums. 
// Space Complexity : O(1).

public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length;        
        while(low <= high){
            int mid = low + (high - low) / 2;
            //if mid reaches 0 or n-1 or the value at mid is greater than both its neighbors then return peak.
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid] > nums[mid + 1]))
                return mid;
            //if the numbers are decreasing, searching to left.  
            if(mid > 0 && nums[mid - 1] >= nums[mid])
                high = mid - 1;
            //if the numbers are increasing, searching to right. 
            else
                low = mid + 1;
        }
        return -1;
    }
}
