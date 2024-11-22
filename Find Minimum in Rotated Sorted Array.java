//in rotated sorted array one part will always be sorted where in mid we have mid.
//and out smallst ele will always be in unsorted part 
//tc- logn
class Solution {
    public int findMin(int[] nums) {
        if(nums == null && nums.length == 0) return -1;

        int low = 0, high = nums.length-1;

        while(low <= high){
            if(nums[low] <= nums[high]) return nums[low];//if its sorted low is min

            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){//left sorted
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return 1234;
    }
}