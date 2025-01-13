namespace LeetCodeSubmission.BinarySearch2;

public class FindThePeakElement
{
    public int FindPeakElement(int[] nums)
    {
        int peakElement = -1;
        
        int low = 0;
        int high = nums.GetLength(0) - 1;
        
        // base-case; length == 1
        if (nums.GetLength(0) == 1)
        {
            return 0;
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
                low = mid + 1; // possibility to get the peak element on the rhs
            }
        }

        return peakElement;
    }
}