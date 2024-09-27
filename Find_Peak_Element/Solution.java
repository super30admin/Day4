// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * 1. Peak element is for sure largest element of the array. So we try to go towards largest element in each iteration
 * 2. We use binary search and calculate mid.
 * 3. Now if mid is 0-index, then next element should smaller than nums[mid]. If mid is pointing to last element of array, then previous element should be smaller than nums[mid] 
 *    or else if mid is pointing to any element in between, element before mid and element next to mid should be smaller than element at mid.
 * 4. If any of above condition is met, we found our ans.
 * 5. Else, we can go on left or right of mid.
 * 6. For this we choose side, where larger element lies (i.e. mid-1 or mid+1 whichever has larger element than mid).
 * 7. To overcome the case of both having same element, we first check mid+1 index, if it has larger element than mid, we go to right of mid or else we go to left of mid
*/



class Solution {
    public int findPeakElement(int[] nums) {
        if(nums .length == 0 || nums == null)return -1;
        if(nums.length == 1)return 0;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
        int mid = low + (high - low) / 2;
            
            if((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length -1 && nums[mid] > nums[mid - 1]) || (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]))return mid;
            
            else{
                if(nums[mid + 1] > nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}