// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] out = new int[2];
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                int halfL = mid - 1;
                int halfR = mid + 1;


                while (halfL>=0 && nums[halfL] == target ){
                    halfL--;
                }
                halfL++;
                out[0] = halfL;

                while (halfR<=end && nums[halfR] == target  ){
                    halfR++;

                }
                halfR--;
                out[1] = halfR;
                return out;
            }

            if (nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }

        out[0] = -1;
        out[1] = -1;
        return out;
    }
}