// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * 1. If array is rotated then there are two sub-arrays in nums, both sorted in ascending order. If nums is not rotated, first array has 0 elements where as 2nd has all the elements
 * 2. Our goal is to find smallest element, which is 1st element of 2nd sub-array
 * 3. So we apply binary search and we look for certain properties that min element in nums posses
 * 4. if the smallest lies in between, then element next to it and element before it, both are greater
 * 5. if min lies at index-0 then next element is greater than it or if min lies at last index, previous element is greater than it.
 * 6. So in binary search, we calculate mid and check if any one of above condition is met. If met we got our ans
 * 7. else we check on left of mid, if mid element is part of 1st sub-array. Now element is part of 1st subarray if mid element is smaller than element at pointer high
 * 8. or we check on right side of mid, if mid element is part of 2nd sub-array. Now element is part of 2nd sub-array if mid element is greater than element at pointer high 
*/



class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null)return -1;
        if(nums.length == 1)return nums[0];
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if((mid == 0 && nums[mid] < nums[mid + 1]) || (mid == nums.length -1 && nums[mid] < nums[mid-1]) || (mid > 0 && nums[mid-1] > nums[mid] && nums[mid + 1] > nums[mid]))return nums[mid];
            else{
                if(nums[mid] > nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
               
               return -1;
        
    }
}