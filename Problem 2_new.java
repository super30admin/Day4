//Time Complexity: O(log n) (Binary search)
//Space Complexity: O(1)

class FindMinimum {
    public int findMin(int[] nums)
    {   
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end)
        {
            int mid = start + (end - start)/2;
            
            if(mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            if(nums[start] <= nums[mid] && nums[mid] > nums[end])
                start = mid + 1;
            else 
                end = mid - 1;
        }
        return nums[start];
    }
}

