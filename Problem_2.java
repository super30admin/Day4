// Time Complexity : O(log(n)) where n = number of elements in nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem_2 {

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] <= nums[hi]) { // If the nums array is fully sorted, return the first element
            return nums[lo];
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2; // Find mid index
            if (mid != nums.length-1 && nums[mid] > nums[mid+1]) { // If the element at mid index is greater than next element, it is the point of rotation, so return the next element
                return nums[mid+1];
            } else if (mid != 0 && nums[mid] < nums[mid-1]) { // If the element at mid index is less than previous element, it is the point of rotation, so return the element at mid index
                return nums[mid];
            } else if (nums[mid] > nums[lo]) { // If left part of the array is sorted, search in the right part
                lo = mid + 1;
            } else { // If right part of the array is sorted, search in the left part
                hi = mid - 1;
            }
        }
        return -1; // If pivot not found, return -1
    }

    public static void main(String[] args) {
        int[] arr = {3,4,7,9,2};
        int ans = findMin(arr);
        System.out.println(ans);
    }
}
