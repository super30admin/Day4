//Binary search and compare the mid value with its previous value and return the mid if it is lesser.
//It comes down to the last two elements in the array and the possibility of first element being
// minimum is already checked as optimization in the beginning.

public class FindMinInRotated {
    public static int findMin(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        if(nums[low] <= nums[high] || length == 1) {
            return nums[low];
        }
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            else if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,8,1,2,3,4};
        System.out.println("Min is " + findMin(nums));
    }
}
