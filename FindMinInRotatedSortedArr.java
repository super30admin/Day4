class Solution {
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - min element can occur in two scenarios, first when mid-1 element is larger than mid elememt, then mid is smallest (because mid-1 is inflection point)
    // second when element at mid+1 is smaller than element at mid, mid is inflection point and mid+1 element is smallest.
    //otherwise check for unsorted part of array and search min element there.
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        if (nums[high] > nums[low] || nums.length == 1) { //not rotated or length is 1
            return nums[0];
        }


        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid+1] < nums[mid]) { //case when min is right of mid
                return nums[mid+1];
            }

            else if(nums[mid] < nums[mid-1] ) { //case when mid is minimum
                return nums[mid];
            }

            else if(nums[low] <= nums[mid]) { //sorted part, search in unsorted part
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}