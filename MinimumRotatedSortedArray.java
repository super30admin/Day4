public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int low =0, high = nums.length-1;
        while(high>=low){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high-low)/2;

            if((mid == nums.length-1 || nums[mid] < nums[mid+1])
                    && (mid==0 || nums[mid] < nums[mid-1])){
                return nums[mid];
            }

            if(nums[low] <= nums[mid]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
