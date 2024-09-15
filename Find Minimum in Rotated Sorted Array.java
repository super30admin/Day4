//Time complexity:O(logn)
//Space complexity:O(1)
// Leetcode perfect execution:yes

class Solution {
    public int findMin(int[] nums) {
        
        if(nums==null || nums.length==0) return -1;
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            
            if((mid==0 ||nums[mid-1]>nums[mid]) && (mid==nums.length-1 || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
                
            else if(nums[mid]<nums[lo])
            {
                return hi=mid-1;
            }
            else 
            {
                return lo=mid+1;
            }
        }
        return nums[0];
      
    }
}
