// 1 test case failed
class Minimum {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mid = (low + high) / 2;
       while (low <= high){
           if (nums[low] <= nums[high]) {
               return nums[low];
           } else low = mid + 1;
       }
        return -1;
    }
}