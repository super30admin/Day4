//time complexity - O(log n) - Modifying binary search
//space cost - constant
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findOccurence(nums, target, true);
        result[1] = findOccurence(nums, target, false);
        return result;
    }
    
    public int findOccurence(int[] nums, int target, boolean firstOccurence) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while(low <= high) 
        {
            int middle = low + (high - low) / 2;
            if(nums[middle] == target)
            {
                result = middle;
                if(firstOccurence)
                {
                    high = middle - 1;
                }
                else
                {
                    low = middle + 1;
                }
            }
            else if(target < nums[middle])
            {
                high = middle - 1;
            }
            else
            {
                low = middle + 1;
            }
        }
        return result;
    }
}
