// Time Complexity : All the operations are done in O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Binary search with conditions such that:
1. if mid value is less than mid+1 value, then start searching from mid+1.
2. if mid value is greater than mid+1 value, then search till mid value.
*/

import java.util.Arrays;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start < end){
            mid = start + (end - start)/2;
            if(nums[mid] < nums[mid+1]){
                start = mid + 1;
            } else if(nums[mid] > nums[mid+1]){
                end = mid;
            }
        }
        return start;
    }

    public static void main(String args[]){
        int[] nums = {1,2,3,1};

        System.out.println("nums1 sol: " + findPeakElement(nums));

        int[] nums2 = {1,2,1,3,5,6,4};

        System.out.println("nums2 sol: " + findPeakElement(nums2));
    }
}

