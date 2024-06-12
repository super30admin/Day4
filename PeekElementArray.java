// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class PeekElementArray {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int midIndex;
        while(start < end){
            midIndex = (start + end) / 2;
            if(nums[midIndex] > nums[midIndex + 1])
                end = midIndex;
            else
                start = midIndex + 1;
        }
        return start;
    }
}