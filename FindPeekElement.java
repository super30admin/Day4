class Solution {
    public int findPeakElement(int[] nums) {//will work because 3 number are not same and together
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if((mid==0 ||nums[mid-1]<nums[mid])&& (mid==nums.length-1 ||nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}

//timecomplexity : O(logn)
//space: O(1)
//ran successfully on leetcode
//easy to understand after class
