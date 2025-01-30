// Time Complexity :o(logn)
// Space Complexity :o(1) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no
class Solution {

    public int binarysearchfirst(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            } 
            else if(nums[mid] > target){
                high = mid - 1;

            } else low = mid + 1; 
        }
        return -1; 
    }
    public int second(int[] nums, int low, int high, int target)

    {

        while (low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){

                if(mid == high || nums[mid + 1] > target) return mid;

                // still go right

                else low = mid + 1;

            } else if(nums[mid] > target){

                high = mid - 1;

            } else low = mid + 1; 

        }

        return -1; 

    }

    public int[] searchRange(int[] nums, int target) {

        int left = first(nums, 0, nums.length - 1, target);

        int right = second(nums, 0, nums.length - 1, target);

        return new int[] {left,right};

    }

}