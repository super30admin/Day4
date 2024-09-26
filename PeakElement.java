// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach we start from the first element and go on to check each element
//we don't need to check the previous element here when we want to find the peak element
//the loop goes to the next iteration only when the next element is greater than the current element.
//this when it goes to the next iteration we know the previous element is smaller and we only need to compare the current element to the next element
//the moment we find the next element is larger , we have the peak element.

class Solution {
    public int findPeakElement(int[] nums) {
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length-1;
    }
}