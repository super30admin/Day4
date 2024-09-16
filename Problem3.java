public class Problem3 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] > nums[1]){
            return 0;
        }
        if (nums[n-1] > nums[n-2]){
            return n-1;
        }
        int l = 0;
        int h = n - 1;
        while (l <= h){
            int mid = l + (h - l)/2;
            if ((mid == n-1 || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1])){
                return mid;
            }
            if (mid > 0 && nums[mid - 1] > nums[mid]){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
