// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

public class FindMinimum {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low];
            int middle = low + (high - low) / 2;
            if (middle > 0 && nums[middle - 1] > nums[middle])
                return nums[middle];
            else if (nums[middle] <= nums[high]) {
                high = middle - 1;
            } else
                low = middle + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        FindMinimum binarySearch=new FindMinimum();
        System.out.println(binarySearch.findMin(nums));
    }
}
