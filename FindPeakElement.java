public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 && nums==null)
            return -1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if((mid == high || nums[mid]>nums[mid+1]) && (mid == low ||nums[mid] > nums[mid-1])){
                return mid;
            }if(nums[mid]<nums[mid+1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}


