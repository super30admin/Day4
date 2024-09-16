// Time Complexity : O(log n) since we are doing binary search 
// Space Complexity : O(1) iterative
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : if I am doing end - start to calculate mid, I am facing an infinite loop in one of the inputs!
/* Algorithm: We first find the mid element and then compare the mid element with the start and end positioned element. If end is greater than start
it implies that the array is sorted and hence, start is minimum. If mid is greater than the start => array is sorted, min/pivot must be on
the unsorted side. Check on the other side.*/


class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        if (nums == null || nums.length == 0){
            return -1;
        } 
        if(nums.length == 1){               // Base Case
            return nums[start];
        }
        int pivot = SearchPivot(start, end, nums);
        return pivot;
    }
    public int SearchPivot(int start, int end, int[] nums){
       if(nums[end] > nums[0]){
            return nums[0];             // If end is greater than start => Sorted Array
        }
        while(start <= end){
        int mid = (start+(end))/2;
        if(nums[mid] > nums[mid+1]){
            return nums[mid+1];         // Pivot Spotted since the next element than mid is smaller
        } else
        if(nums[mid] < nums[mid-1])
        {
            return nums[mid];           // Pivot Spotted since the previous element than mid is greater
        }
        else {
        if(nums[0] < nums[mid]){
            start = mid + 1;            // if start is lesser than mid, Go in the unsorted part
        } else {
            end = mid-1;                // else Go in the sorted side for min element that should be the start element.
        }
        }
        }
        return -1;                      // Just to fulfill return type since pivot/min will always be there
    }
}