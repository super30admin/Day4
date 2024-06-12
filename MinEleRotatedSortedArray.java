// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class MinEleRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int midIndex = 0;
        int minElement = nums[0];
        while(start <= end){
            midIndex = start + (end - start) /2 ;
            minElement = Math.min(nums[midIndex], minElement);
            if(nums[midIndex] < nums[start]){
                end = midIndex - 1;
            }
            else if(nums[midIndex] > nums[end]){
                start = midIndex + 1;
            }
            else{
                minElement = Math.min(nums[start], minElement);
                return minElement;
            }
        }
        return minElement;
    }
}