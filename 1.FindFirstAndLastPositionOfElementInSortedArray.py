/*
Time Complexity: 0(2 log n)
Space Complexity: 0(1)
Approach: Perform binary search two time to find lhs possible index & rhs possible index 
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {

        // return the result array
        int[] result = new int[2];
        // set both lhs and rhs result to -1,-1
        result[0] = -1; 
        result[1] = -1;

        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        // binary search on lhs -- find the lowest possible fit
        while (low <= high){

            mid = ((high-low)/2) + low;

            if (nums[mid] == target){
                // found the potential mid for lhs
                result[0] = mid;
                high = mid - 1;
            }

            else if (nums[mid] < target){
                // result on the rhs
                low = mid + 1;
            }

            else {
                // result on lhs
                high = mid - 1;
            }

        }
        // end of lhs binary search

        // reset the pts
        low = 0;
        high = nums.length-1;
        mid = 0;

        // perform binary search on rhs -- find the highest possible fit
        while(low <= high){

            mid = ((high-low)/2) + low;

            if (nums[mid] == target){
                // found the potential mid for rhs
                result[1] = mid;
                low = mid + 1;
            }

            else if (nums[mid] < target){
                // result on the rhs
                low = mid + 1;
            }

            else {
                // result on lhs
                high = mid - 1;
            }

        }
        // end of binary search

        return result;
    }
}