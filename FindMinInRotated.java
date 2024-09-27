class Solution {
    public int findMin(int[] nums) {
        
        int l=0;
        int h=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            System.out.println(l+" "+m+" "+h);
            if(nums[l]<=nums[h])
                return nums[l];
            
            if((m==0 || nums[m]<nums[m-1]) && (m==nums.length-1 || nums[m]<nums[m+1]))
                return nums[m];
            
            if(nums[l]<=nums[m])
            {
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return nums[l];
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no