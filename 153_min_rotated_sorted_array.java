//Calculate the pivot and that would be the minimum element
//Overall Time Complexity: O(log(N))
//Overall Space Complexity: O(1)
class Solution {
    //Time Complexity: O(log(N))
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length-1 ;

        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low]; //Array already sorted
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid - 1] > nums[mid] )
                    && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }else if(nums[mid] >= nums[low]){
                low = mid + 1; //Left Sorted Array
            }else{
                high = mid - 1; //Right Sorted Array
            }
        }

        return -1;
    }
}