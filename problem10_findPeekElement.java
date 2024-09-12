package BinarySearch2;

public class problem10_findPeekElement {
    /*
    Brute Force ---->
        Time Complexity : O(n)
        Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(mid != 0 && nums[mid] <  nums[mid - 1]) // move left
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 99999;
    }
    public static void main(String[] args) {
        /*
        Sample 1:
            Input: nums = [1,2,3,1]
            Output: 2
            Explanation: 3 is a peak element and your function should return the index number 2. Example 2:

        Sample 2:
            Input: nums = [1,2,1,3,5,6,4]
            Output: 1 or 5
            Explanation: Your function can return either index number 1 where the peak element is 2,
         */
    }
}