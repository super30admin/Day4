namespace Algorithms
{

    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public class LeftAndRightIndexTargetArray
    {
        //Time Complexity - O(log n) since we reduced the search space by half in each iteration of our search
        //Spacce Complexity - O(1) - Since we did not use any additional search space
        public int[] SearchRange(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0)
            {
                return new int[] { -1, -1 };
            }

            var left = 0;
            var right = nums.Length - 1;

            // Search for the first occurence of the target 
            while (left <= right)  
            {
                var mid = left + (right - left) / 2;
                if (nums[mid] == target)
                {
                    // From first element till the first occurance of the target perform binary search to get the left index
                    var leftIndex = BinarySearchLeft(nums, left, mid, target);
                    // From left Index until Last element, perform binary search to find the right most index of the target
                    var rightIndex = BinarySearchRight(nums, leftIndex, right, target);
                    if (leftIndex == -1 || rightIndex == -1) return new int[] { -1, -1 };
                    return new int[] { leftIndex, rightIndex };
                }
                else if (nums[mid] > target)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return new int[] { -1, -1 };
        }
        

        private int BinarySearchLeft(int[] nums, int left, int right, int target)
        {
            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if(mid == 0 || nums[mid] > nums[mid - 1])
                    {
                        return mid;
                    }
                    else
                    {
                        right = mid - 1;
                    }
                }
                else if (nums[mid] > target) {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int BinarySearchRight(int[] nums, int left, int right, int target)
        {
            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                if (nums[mid] == target)
                {
                    if (mid == nums.Length-1 || nums[mid] < nums[mid + 1])
                    {
                        return mid;
                    }
                    else
                    {
                        left = mid + 1;
                    }
                }
                else if (nums[mid] > target)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
