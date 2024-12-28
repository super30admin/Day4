public class FindPeakElement{
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;

        while(high>low){
            int mid = low + (high - low)/2;
            if(nums[mid] < nums[mid+1]){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low;
    }
}
