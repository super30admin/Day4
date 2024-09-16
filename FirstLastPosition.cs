// Time complexity: O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes (https://leetcode.com/submissions/detail/569648307/)
// Any problem you faced while coding this:
namespace BinarySearch2
{
    class FirstLastPosition 
    {        
        public int[] SearchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.Length - 1;
            int[] result = new int[2]{-1, -1};
            int foundFlag = 0;

            if(nums.Length < 1 || target < nums[left] || target > nums[right]) {
                return result;
            }

            //Finding left most element
            while(left <= right) {
                int mid = left + (right - left)/2;

                if(nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                    foundFlag = 1;
                }
            }
            if(foundFlag == 1) {
                result[0] = left;
            } else {
                return result;
            }

            left = 0;
            right = nums.Length - 1;

            //Finding right most element
            while(left <= right) {
                int mid = left + (right - left)/2;

                if(nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    left = mid + 1;
                }
            }

            result[1] = right; 
            return result;
        }

        static void Main(string[] args) {
            FirstLastPosition find = new FirstLastPosition();
            int[] nums = new int[]{5, 7, 7, 8, 8, 10};
            int[] result = find.SearchRange(nums, 8);
            Console.Write(result[0] + ",");
            Console.Write(result[1]);
        }
    }
}
