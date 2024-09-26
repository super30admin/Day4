/**
 * Time Complexity : O(N) where N is size of the array.
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes, could not figure our O(logN) solution
 */

public class FindPeakElement {
    public static void main(String args[]){
        int[] nums = {1,2,2,3,1,2};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                return i;
            }
        }
        return len - 1;
    }
}