//Find Minimum in Rotated Sorted Array
// Time Complexity: O(n).
//Space Complexity: O(1).

class Solution {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int i: nums){

            min = Math.min(min,i);
        }

        return min;

    }
}