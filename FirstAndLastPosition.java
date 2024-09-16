/*
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Took a long time to come up with the condition and bounds

Your code here along with comments explaining your approach
1. Get the left and right range separately
2. For left position - 
    if middle element >= target, the search space reduces to left half, else to right half
3. For right position -
    if middle element <= target, the serahc space is the right half, else left half
    reduce low by 1 since, it would point to next higher element
*/

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        int left = leftBinarySearch(nums, target);
        int right = rightBinarySearch(nums, target);
        
        return new int[] {left, right};
    }
    
    public int leftBinarySearch(int[] a, int target) {
        int low = 0, high = a.length;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low)/2;
            if (a[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low == a.length || a[low] != target) {
            return -1;
        }
        return low;
    }
    
    public int rightBinarySearch(int[] a, int target) {
        int low = 0, high = a.length;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low)/2;
            if (a[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        low--;
        if (low < 0 || a[low] != target) {
            return -1;
        }
        return low;
    }
}