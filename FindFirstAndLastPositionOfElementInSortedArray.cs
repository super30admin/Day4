namespace LeetCodeSubmission.BinarySearch2;

public class FindFirstAndLastPositionOfElementInSortedArray
{
    public int binarySearch(int low, int high, int[] nums, int target)
    {
        while (low <= high)
        {
            int mid = (high - low) / 2 + low;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
            {
                // target is smaller than mid
                // target is on lhs
                // update high value
                high = mid - 1;
            }
            else if (nums[mid] < target)
            {
                // target is grater than mid
                // target is on rhs
                // update low
                low = mid + 1;
            }
        }
        
        // default return
        return -1;
    }
    public int[] SearchRange(int[] nums, int target)
    {
        int[] result = new[] { -1, -1 };
        
        // base-case
        if (nums.GetLength(0) == 0)
        {
            return result;
        }
        
        // get the lowest possible value on lhs i.e. log(n/2)
        int high = nums.GetLength(0) - 1;
        while (true)
        {
            int lhsVal = this.binarySearch(0, high, nums, target);
            
            if (lhsVal != -1)
            {
                result[0] = lhsVal;
                high = lhsVal - 1;
                continue;
            }
            break;
        }
        
        // get the highest possible value on rhs i.e. log(n/2)
        int low = 0;
        while (true)
        {
            int rhsVal = this.binarySearch(low,nums.GetLength(0)-1, nums, target);
            if (rhsVal != -1)
            {
                result[1] = rhsVal;
                low = rhsVal + 1;
                continue;
            }
            break;
        }
        
        /*int midPt = this.binarySearch(0, nums.GetLength(0) - 1, nums, target); //log(n)
        
        if (midPt != -1)
        {
            result[0] = midPt;
            result[1] = midPt;

            // get the lowest possible value on lhs i.e. log(n/2)
            while (true)
            {
                int lhsVal = this.binarySearch(0, result[0] - 1, nums, target);
            
                if (lhsVal != -1)
                {
                    result[0] = lhsVal;
                    continue;
                }
                break;
            }

            // get the highest possible value on rhs i.e. log(n/2)
            while (true)
            {
                int rhsVal = this.binarySearch(result[1]+1,nums.GetLength(0)-1, nums, target);
                if (rhsVal != -1)
                {
                    result[1] = rhsVal;
                    continue;
                }
                break;
            }
        }*/
        
        // default return -1,-1
        return result;
    }
}