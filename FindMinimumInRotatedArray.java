// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int mid = 0 ;


        while(low <= high){

            mid = low + (high - low)/2;

            if(nums[mid] == nums[low]){
                if(nums[mid] > nums[high]) return nums[high];
                return nums[low];
            }

            if(nums[mid] > nums[low] && nums[mid] < nums[high]){
                high = mid -1;
            }
            else if(nums[mid] > nums[low]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        return nums[0];

    }
}
