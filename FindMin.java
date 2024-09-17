//Runtime: loog(n) - used Binary Search, all other calculations are O(1)
//Space Complexity: O(1)
//Passed on Leetcode
//No difficulty coding


public class FindMin {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            if(nums[low] < nums[high]){
                return nums[low];
            }
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length-1 || nums[mid] < nums[mid + 1])){

                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){  //this means left is sorted
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}