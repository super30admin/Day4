//Binary search to find peak. From mid, always go to the side of the mid which is higher than mid
// which guarantees to find a peak and also limiting the search space.

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        if(length == 1) {
            return low;
        }
        while(low<=high) {
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1])
                    &&
                    (mid == length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if(mid != 0 && nums[mid] < nums[mid-1]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        int[] nums = {0,1,3,6};
        System.out.println("Peak is " + peakElement.findPeakElement(nums));
    }
}
