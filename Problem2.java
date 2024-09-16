public class Problem2 {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h){
            if (nums[l] <= nums[h]){
                return nums[l];
            }
            int mid = l + (h - l)/2;
            if ((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            else if (nums[l] <= nums[mid]){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return -1;
    }
    
}
