namespace LeetCodeSubmission.BinarySearch2;

public class FindMinimumInRotatedSortedArray
{
    public int FindPeakElement(int[] nums)
    {
        int peakElement = 0;
        
        int low = 0;
        int high = nums.GetLength(0) - 1;
        
        // base-case; length == 1
        if (nums.GetLength(0) == 1)
        {
            return peakElement;
        }
        
        // logic-case
        while (low <= high)
        {
            int mid = (high - low) / 2 + low;
            
            // chk for in bounds
            if ((mid - 1 >= 0 && mid + 1 <= nums.GetLength(0)-1)&& 
                (nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]))
            {
                peakElement = mid;
                break;
            }
            else if ((mid - 1 < 0 && mid + 1 <= nums.GetLength(0)-1)&& 
                     (nums[mid]>nums[mid+1]))
            {
                peakElement = mid;
                break;
            }
            else if ((mid - 1 >= 0 && mid + 1 > nums.GetLength(0)-1)&& 
                     (nums[mid-1]<nums[mid]))
            {
                peakElement = mid;
                break;
            }
            else
            {
                // chk where is larger element, move towards that direction
                if (nums[mid + 1] >= nums[mid])
                {
                    low = mid + 1; // possibility to get the peak element on the rhs
                }
                else
                {
                    high = mid - 1;// possibility to get the peak element on lhs
                }
            }
        }

        return peakElement;
    }
}