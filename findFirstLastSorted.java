// Time Complexity : All the operations are done in O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Search for the start of the target element through firstIndex method using binary search and same way search for last index through lastIndex method using binary search. */

import java.util.Arrays;

public class findFirstLastSorted {
    public static int[] searchRange(int[] nums, int target) {
        int start = firstIndex(nums, target);
        int end = lastIndex(nums, target);

        return new int[]{start,end};
    }

    public static int firstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int firstInd = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            } else if (nums[mid]>target){
                high = mid-1;
            }else{
                firstInd = mid;
                high = mid - 1;
            }
        }
        return firstInd;
    }

    public static int lastIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int lastInd = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            } else if (nums[mid]>target){
                high = mid-1;
            }else{
                lastInd = mid;
                low = mid + 1;
            }
        }
        return lastInd;
    }

    public static void main(String args[]){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println("nums1 sol: " + Arrays.toString(searchRange(nums, target)));

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;

        System.out.println("nums2 sol: " + Arrays.toString(searchRange(nums2, target2)));
    }
}

