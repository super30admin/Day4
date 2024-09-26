class Solution {
    public int findMin(int[] nums) {
        //mid-1>mid<mid+1 ---condition
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if((mid==0 || nums[mid-1]>nums[mid])&& (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[mid]>nums[high]) 
               low=mid+1;
            else
               high=mid-1;
              
        }
               return -1;
    }
}
               
               
               //time : O(log n)
               //space:O(1)
               //ran successfully on leetcode
               //I solved this question before with different approach was easy to understand and implement this after class
