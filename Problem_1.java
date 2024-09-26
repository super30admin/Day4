// Time Complexity : O(log(n)) where n = number of elements in nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class Problem_1 {
    
    // Get starting position of target
    private static int getstartpos(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Find mid index
            if (nums[mid] == target) { // If target is found at middle index
                if (mid == 0 || nums[mid-1] != target) { // If it is first element in array or previous element is not target, return mid index
                    return mid;
                } else { // Else search in the left part of the array
                    hi = mid - 1;
                }
            } else if (nums[mid] > target) { // If element at mid index is greater than target
                hi = mid - 1; // Search in the left part of the array
            } else { // Else if element at mid index is smaller than target
                lo = mid + 1; // Search in the right part of the array
            }
        }
        return -1; // If not found, return -1
    }
    
    // Get End position of target
    private static int getendpos(int[] nums, int target, int startpos) {
        if (startpos == -1) {
            return -1; // If starting position is not found, target is not present in array, so return -1
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Find mid index
            if (nums[mid] == target) { // If target is found at middle index
                if (mid == nums.length - 1 || nums[mid+1] != target) { // If it is last element in array or next element is not target, return mid index
                    return mid; 
                } else { // Else search in the right part of the array
                    lo = mid + 1;
                }
            } else if (nums[mid] > target) { // If element at mid index is greater than target
                hi = mid - 1; // Search in the left part of the array
            } else { // Else if element at mid index is smaller than target
                lo = mid + 1; // Search in the right part of the array
            }
        }
        return -1;
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int startpos = getstartpos(nums, target); // Get start index
        int endpos = getendpos(nums, target, startpos); // Get end index
        return new int[]{startpos, endpos}; // Return array containing start index and end index
    }
    public static void main(String[] args) {
        int[] nums = {5,7,8,9,9,10};
        int target = 9;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

}