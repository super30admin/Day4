// Time Complexity : O(log(n)) where n = number of elements in nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem_3 {
    
    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Find mid index
            boolean midgtleft = mid == 0 || nums[mid] > nums[mid-1]; // check if element at mid greater than previous element
            boolean midgtright = mid == nums.length - 1 || nums[mid] > nums[mid + 1]; // check if element at mid greater than next element
            if (midgtleft && midgtright) { // if element at mid is peak
                return mid;
            } else if (midgtleft) { // if element at mid greater than previous element, there is definitely a peak in the right part, so search in the right part of array
                lo = mid + 1;
            } else { // if element at mid greater than next element, there is definitely a peak in the left part, so search in the left part of array
                hi = mid - 1;
            }    
        }
        return -1; // if no peak found, return -1
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        int ans = findPeakElement(arr);
        System.out.println(ans);
    }
}
