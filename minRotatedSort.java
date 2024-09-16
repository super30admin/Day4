// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
public class minRotatedSort {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return nums[low];
    }
}
