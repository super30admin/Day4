public class Solution {
    //Time Complexity : O(log(n))
    //Space Complexity: O(1)
    public int FindPeakElement(int[] nums) {
       int low = 0, high = nums.Length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}