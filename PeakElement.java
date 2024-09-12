/*
This program finds the solution using binary search. It checks if the middle element
is greater than its adjacent elements. If it is not greater than its adjacent elements,
it goes in the direction of the greater adjacent element, as the likelihood of finding
a peak in that direction is guaranteed.

Problems with this code: None

Did this run on leetcode: Yes



*/



class Solution {
    //Time Complexity = O(log(n))
    //Space Complexity = O(1)
    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        int mid;
        
        
        while(low <= high)
        {
            mid = low +(high - low)/2;
            //Checking edge cases when mid is first or last element, so that there is no index out of bounds during comparison
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1]))
                return mid;
            
            else if(nums[mid] < nums[mid+1])
                low = mid + 1;
            
            else if(nums[mid] < nums[mid-1])
                high = mid - 1;
        }
        
        return -1;
        
    }
}