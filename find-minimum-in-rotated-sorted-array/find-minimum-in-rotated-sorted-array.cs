public class Solution {
    public int FindMin(int[] nums) {
        if(nums.Length==1)
        {
            return nums[0];
        }
        
        int left =0;
        int right =nums.Length-1;
        int mid =0;
        
        if(nums[right] > nums[0])
        {
            return nums[0];
        }
        
        while(right>=left)
        {
            mid = left+ (right-left)/2;
            
            if(nums[mid] > nums[mid+1])
            {
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid])
            {
                return nums[mid];
            }
            if(nums[mid] > nums[0])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        
        return -1;
        
    }
}
