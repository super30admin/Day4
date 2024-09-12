/*
Time Complexity: O(log n)
Space Complexity: O(1)


*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findstart(nums,target);
        result[1] = findend(nums,target);
        return result;    
    }
    
    public int findstart(int[]nums, int target)
    {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(target<=nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
            if(nums[mid]==target)
                index = mid;
        }
        
        return index;
    }
    
    public int findend(int[]nums, int target)
    {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(target>=nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }   
            if(nums[mid]==target)
                index = mid;            
        }
        
        return index;
    }
    
}