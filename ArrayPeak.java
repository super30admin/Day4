/**
 * time complexity is O(logn)
 * space complexity is O(1)
 * leetcode test cases - pass
 */
public class ArrayPeak {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[len-1] > nums[len-2]) {
            return len-1;
        }
        return peak(nums);
    }
    private int peak(int[] nums) {
        int left = 1;
        int right = nums.length-2;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }    
}
