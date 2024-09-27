// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. Write the code to find pivot
*/

class Solution {
    public int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        return findNum(nums, low, high);
        
    }
    
    public int findNum(int[] arr, int low, int high) {
        int mid = low + (high - low)/2;
        if (high < low)  return arr[0];
        if (high == low) return arr[low];
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
        if (arr[high] > arr[mid])
            return findNum(arr, low, mid-1);
        return findNum(arr, mid+1, high);
    }
}