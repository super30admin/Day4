//162. Find Peak Element - Passed all test cases
/*
    TC- O(logn)
    SC - O(1)
    Method - Binary Search. Find mid and compare the mid element with mid-1 and mid+1 index.if the mid element is greater than its both neighbors, then return mid element. Else, whichever side has the highest element, move the index accordingly to find the peak element.
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid==0 || nums[mid]>nums[mid-1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}