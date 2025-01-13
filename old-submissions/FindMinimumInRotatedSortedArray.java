class Solution {
    public int findMin(int[] nums) {

        /*
        Time Complexity: 0(log n)
        Space Complexity: 0(1)
        Apprroach: Set the potential target, perform binary search and update the
        potential target if the you find the lowest value. Again perform the binary search
        & return the target if the result remains unchanged.
         */

        // set the potential min target
        int target = nums[nums.length-1];

        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while (low <= high){
            mid = (high-low)/2 + low;

            if(nums[mid] == target){
                // potential mid is unchanged
                break;
            }

            else if (nums[mid] > target){
                if(nums[low]<= nums[mid] && target<nums[low]){
                    //sorted array on lhs, check on rhs
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }

            }
            else if (nums[mid] < target) {
                // found new potential mid target
                target = nums[mid];

                if(nums[mid] <= nums[high]){
                    // sorted array on rhs, check lhs
                    high = mid-1;
                }
                else{
                    low = mid + 1;
                }
            }
        }

        return target;
    }
}