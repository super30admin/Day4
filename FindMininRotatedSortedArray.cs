public class Solution {
//Time Complexity: O(log(n)) as we are following divide and conquer
//Space Complexity: O(1)
    public int FindMin(int[] nums)
        {
            if (nums == null || nums.Length == 0)
            {
                return - 1;
            }
            int low = 0, high = nums.Length - 1;
            if (nums[low] <= nums[high])
            {
                return nums[low];
            }
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[low] <= nums[high])
                {
                    return nums[low];
                }
                if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] < nums[mid + 1])){
                    return nums[mid];
                }
                else if (nums[low] <= nums[mid]){
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return 40584;
   }
}