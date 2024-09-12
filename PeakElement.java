public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        // Our decision is based on the middle element
        // If mid + 1 element is greater than there is possibility of finding a peak
        // as mid + 1 is greater than mid
        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high =mid;
        }

        return low;
    }
}
