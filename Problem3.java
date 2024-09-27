// Find Peak Element
//Time Compexity: O(n)
//Space Complexity: O(1).

class Solution {
    public int findPeakElement(int[] nums) {

        for(int i=0;i<nums.length-1;i++){

            if(nums[i] > nums[i+1]){

                return i;
            }
        }

        return nums.length-1;

    }
}