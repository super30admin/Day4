// Time Complexity: O(log n) where n is the number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            //go in the direction of largest neightbour and shrink the range to find the peak element
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        //l and r will point to the same peak element, can return either l or r
        return r;
    }
}