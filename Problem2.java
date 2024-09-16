/*
Big O Analysis: Time O(Log N), N is # of elements in array
Space: O(1) 

Passed All Test Cases 

Using Binary Search, we check for the unsorted side of the array and then move our low to mid + 1 until we get the sorted array in the unsroted array itself. 
and then we perfrom binarySearch again. The element at the low index is always the minimum element in the sorted array
*/



class Solution {
    public int findMin(int[] nums) {
        int low = 0 ; 
        int high = nums.length - 1 ; 
        
        while (low < high) {
            int mid = low + (high - low) / 2 ;
            
            //check if it is unsorted
        if (nums[mid] > nums[high]) {
            low = mid + 1 ; 
        }
            else//if it is sorted
                high = mid; 
        }
        return nums[low] ; 
    }
}