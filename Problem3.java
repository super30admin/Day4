//PROBLEM - Peak element in array
/** 3 Pointer Approcach: 
 * Fact utilized : If we can get half items to compute at each progressive iterarion  
 * the problem can be resolved in Log N tim here used the approach,
 * when there are Up/Down or Ascending/Descending or Hilly values, we can use Binary Serach.
 * We will find a mid and will move towards higher Number as that guratees finsing a peak.
 * We keep decreasing the serch space till we landed on peak..
 * 
 */ 
//
//time Complexity :
// LOG(N)

// Space Complexity :
//  LOG(N)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.


class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) { 
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0 && nums[mid] > nums[mid + 1]) // first element and greater than nect item;
                return mid; //PEAK
            else if (mid == 0) // if not greater than nect elemnt move to nect item as not a peak
                mid = mid + 1;

            if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) // same analogy as above
                return mid; //PEAK
            else if (mid == nums.length - 1) // same analogy as above
                mid = mid - 1;

            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])
                return mid; // PEAK 
            else if (nums[mid - 1] > nums[mid]) 
                end = mid - 1;  // left is greater than mid then decrease end to left to mid
            else
                start = mid + 1;  // right is greater than mid then increase start to right of mid;

        }

        return -1;
    }
}