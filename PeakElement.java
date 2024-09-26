//// 1 test case failed
class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2; 
            if (mid == 0 || nums[mid -1] < nums[mid] && mid == nums.length -1 || nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
       return -1; 
    }
}