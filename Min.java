//153. Find Minimum in Rotated Sorted Array
public class Min
{

    public static void main(String[] arg)
    {
        int[] nums = {3, 4, 5, 1, 2};
        int ans = findMin(nums);
        System.out.println("___ANS___:" + ans);
    }

    public static int findMin(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] <= nums[high])
            return nums[low];
        while (low <= high)
        {
            if (nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            else if (nums[low] <= nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }

        }
        return -1;
    }
}
