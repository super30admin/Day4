class Solution {
    public int findPeakElement(int[] nums) {
        
        int l=0;int h=nums.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if((m==h || nums[m]>nums[m+1]) && (m==l || nums[m]>nums[m-1]))
            {return m;}
            else if(m==h || nums[m]<nums[m+1])
                l=m+1;
            else 
                h=m-1;
            
        }
        
        return -1;
        
    }
}

// Time Complexity : O(log n)   
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
