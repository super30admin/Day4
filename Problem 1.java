//Time Complexity: O(log n) (Binary Search Algorithm)
//Space Complexity: O(1) (No extra space required)

class FirstAndLast
{
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums, target);
        return result;
    }
    
    public int searchFirst(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else
            {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
    
    public int searchLast(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else
            {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }
    
}