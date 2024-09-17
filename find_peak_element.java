class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == nums.length - 1 || (nums[mid] > nums[mid + 1]) && (mid == 0 || (nums[mid] > nums[mid - 1]))) {
                return mid;
            }
            else if(mid != 0 && nums[mid - 1] > nums[mid]) { //because we dont want mid = 0 in that case we need to move towards right
                high = mid - 1;
            }
            else { // we arent checking for edge case nums.length - 1 cuz there wont be a situation where we will exceed last element. in other words if we ahve reache dalst element it means that prev element is smaller than it
                low = mid + 1;
            }
        }
        return 101;
    }
}