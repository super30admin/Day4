class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
    if (nums.length == 1) {
      return nums[0];
    }   
        
    if(nums[0]< nums[nums.length - 1])
        {
            return nums[0];
        }

    while(low <= high)
    {
        int mid = low + (high - low)/2;

        if (nums[mid] > nums[mid + 1])
         {
             return nums[mid + 1];
         }
        if (nums[mid - 1] > nums[mid]) 
        {
               return nums[mid];
        }
        if(nums[mid] > nums[high])
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