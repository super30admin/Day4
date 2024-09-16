/**
 * Time complexity is O(log n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 */
public class FindPeakElementIndex {
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        FindPeakElementIndex obj = new FindPeakElementIndex();
        int peakIndex = obj.findPeakElement(nums);
        System.out.println(peakIndex);
    }

    private int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(mid != 0 && nums[mid-1] > nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return 12345;
    }
}
