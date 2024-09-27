//Time complexity: O(log(n))
//Space complexity: O(1)
//compiled in leetcode.

class Solution {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r= nums.length-1;
        int out[] = new int[2];
        
        
        
        if(l<=r)
        {
           searchIndex(nums, target, l ,r);
        }
        if(min == Integer.MAX_VALUE)
            out[0] = -1;
        else
            out[0] = min;
        if(max == Integer.MIN_VALUE)
            out[1] = -1;
        else
            out[1] = max;
        return out;
        }
    
    
    void searchIndex(int[] nums, int target, int l, int r)
    {
            if(l>r)
                return;
            int mid= l+(r-l)/2;
            if(nums[mid]>target)				//if target is less than mid disregarding second part.
            {
                r = mid-1;
            }
            else if(nums[mid]<target)			//if target is greater than mid disregarding first part.
            {
                l = mid+1;
            }
            else								// min and max will be set and calling left and right parts for binary search again.
            {
                if(mid >= max)
                {
                    max = mid;
                }
                if(mid<=min)
                {
                    min = mid;
                }                
            }
        searchIndex(nums, target, l, mid-1);
        searchIndex(nums, target, mid+1, r);
    }
}
