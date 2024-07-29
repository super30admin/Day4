/**
 * Find peak of the element
 * essentially an element-> nums[i], where nums[i-1]<nums[i]< nums[i+1]
 * Time complexity= O(log(n))
 * Space complexity = O(1)
 * Approach move towards the greater number. (like a peak.)
 * And divide the search into half.
 */
class FindPeak {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {// till last number.
            int mid = left + (right-left)/2;
            if((mid==0 || nums[mid]> nums[mid-1]) && (mid== nums.length-1 || nums[mid]> nums[mid+1]) ) {
                return mid;
            } else if(nums[mid]<=nums[mid+1]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}